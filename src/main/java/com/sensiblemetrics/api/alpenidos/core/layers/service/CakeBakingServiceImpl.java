package com.sensiblemetrics.api.alpenidos.core.layers.service;

import com.sensiblemetrics.api.alpenidos.core.layers.dao.CakeDao;
import com.sensiblemetrics.api.alpenidos.core.layers.dao.CakeLayerDao;
import com.sensiblemetrics.api.alpenidos.core.layers.dao.CakeTopping;
import com.sensiblemetrics.api.alpenidos.core.layers.dao.CakeToppingDao;
import com.sensiblemetrics.api.alpenidos.core.layers.dto.CakeInfo;
import com.sensiblemetrics.api.alpenidos.core.layers.dto.CakeLayerInfo;
import com.sensiblemetrics.api.alpenidos.core.layers.dto.CakeToppingInfo;
import com.sensiblemetrics.api.alpenidos.core.layers.exception.CakeBakingException;
import com.sensiblemetrics.api.alpenidos.core.layers.model.Cake;
import com.sensiblemetrics.api.alpenidos.core.layers.model.CakeLayer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of CakeBakingService
 */
@Service
@Transactional
public class CakeBakingServiceImpl implements CakeBakingService {
    private final AbstractApplicationContext context;

    public CakeBakingServiceImpl() {
        this.context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Override
    public void bakeNewCake(final CakeInfo cakeInfo) throws CakeBakingException {
        final List<CakeTopping> allToppings = getAvailableToppingEntities();
        final List<CakeTopping> matchingToppings = allToppings
            .stream()
            .filter(t -> t.getName().equals(cakeInfo.cakeToppingInfo.name))
            .collect(Collectors.toList());
        if (matchingToppings.isEmpty()) {
            throw new CakeBakingException(String.format("Topping %s is not available", cakeInfo.cakeToppingInfo.name));
        }
        final List<CakeLayer> allLayers = getAvailableLayerEntities();
        final Set<CakeLayer> foundLayers = new HashSet<>();
        for (final CakeLayerInfo info : cakeInfo.cakeLayerInfos) {
            final Optional<CakeLayer> found = allLayers.stream().filter(layer -> layer.getName().equals(info.name)).findFirst();
            if (!found.isPresent()) {
                throw new CakeBakingException(String.format("Layer %s is not available", info.name));
            } else {
                foundLayers.add(found.get());
            }
        }
        final CakeToppingDao toppingBean = context.getBean(CakeToppingDao.class);
        final CakeTopping topping = toppingBean.findById(matchingToppings.iterator().next().getId()).get();
        final CakeDao cakeBean = this.context.getBean(CakeDao.class);
        final Cake cake = new Cake();

        cake.setTopping(topping);
        cake.setLayers(foundLayers);
        cakeBean.save(cake);
        topping.setCake(cake);
        toppingBean.save(topping);

        final CakeLayerDao layerBean = context.getBean(CakeLayerDao.class);
        for (final CakeLayer layer : foundLayers) {
            layer.setCake(cake);
            layerBean.save(layer);
        }
    }

    @Override
    public void saveNewTopping(final CakeToppingInfo toppingInfo) {
        final CakeToppingDao bean = this.context.getBean(CakeToppingDao.class);
        bean.save(new CakeTopping(toppingInfo.name, toppingInfo.calories));
    }

    @Override
    public void saveNewLayer(CakeLayerInfo layerInfo) {
        final CakeLayerDao bean = this.context.getBean(CakeLayerDao.class);
        bean.save(new CakeLayer(layerInfo.name, layerInfo.calories));
    }

    private List<CakeTopping> getAvailableToppingEntities() {
        final CakeToppingDao bean = this.context.getBean(CakeToppingDao.class);
        final List<CakeTopping> result = new ArrayList<>();
        final Iterator<CakeTopping> iterator = bean.findAll().iterator();
        while (iterator.hasNext()) {
            final CakeTopping topping = iterator.next();
            if (topping.getCake() == null) {
                result.add(topping);
            }
        }
        return result;
    }

    @Override
    public List<CakeToppingInfo> getAvailableToppings() {
        final CakeToppingDao bean = this.context.getBean(CakeToppingDao.class);
        final List<CakeToppingInfo> result = new ArrayList<>();
        final Iterator<CakeTopping> iterator = bean.findAll().iterator();
        while (iterator.hasNext()) {
            final CakeTopping next = iterator.next();
            if (next.getCake() == null) {
                result.add(new CakeToppingInfo(next.getId(), next.getName(), next.getCalories()));
            }
        }
        return result;
    }

    private List<CakeLayer> getAvailableLayerEntities() {
        final CakeLayerDao bean = this.context.getBean(CakeLayerDao.class);
        final List<CakeLayer> result = new ArrayList<>();
        final Iterator<CakeLayer> iterator = bean.findAll().iterator();
        while (iterator.hasNext()) {
            final CakeLayer next = iterator.next();
            if (next.getCake() == null) {
                result.add(next);
            }
        }
        return result;
    }

    @Override
    public List<CakeLayerInfo> getAvailableLayers() {
        final CakeLayerDao bean = this.context.getBean(CakeLayerDao.class);
        final List<CakeLayerInfo> result = new ArrayList<>();
        final Iterator<CakeLayer> iterator = bean.findAll().iterator();
        while (iterator.hasNext()) {
            final CakeLayer next = iterator.next();
            if (next.getCake() == null) {
                result.add(new CakeLayerInfo(next.getId(), next.getName(), next.getCalories()));
            }
        }
        return result;
    }

    @Override
    public List<CakeInfo> getAllCakes() {
        final CakeDao cakeBean = this.context.getBean(CakeDao.class);
        final List<CakeInfo> result = new ArrayList<>();
        final Iterator<Cake> iterator = cakeBean.findAll().iterator();
        while (iterator.hasNext()) {
            final Cake cake = iterator.next();
            final CakeToppingInfo cakeToppingInfo = new CakeToppingInfo(cake.getTopping().getId(), cake.getTopping().getName(), cake.getTopping().getCalories());
            final List<CakeLayerInfo> cakeLayerInfos = new ArrayList<>();
            for (final CakeLayer layer : cake.getLayers()) {
                cakeLayerInfos.add(new CakeLayerInfo(layer.getId(), layer.getName(), layer.getCalories()));
            }
            final CakeInfo cakeInfo = new CakeInfo(cake.getId(), cakeToppingInfo, cakeLayerInfos);
            result.add(cakeInfo);
        }
        return result;
    }
}
