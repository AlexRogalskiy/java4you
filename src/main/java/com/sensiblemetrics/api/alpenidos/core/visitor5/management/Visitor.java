package com.sensiblemetrics.api.alpenidos.core.visitor5.management;

import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Circle;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.CompoundShape;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Dot;
import com.sensiblemetrics.api.alpenidos.core.visitor5.model.Rectangle;

public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
