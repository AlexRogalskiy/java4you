package com.sensiblemetrics.api.alpenidos.core.adapter8.management;

import com.sensiblemetrics.api.alpenidos.core.adapter8.dto.OffshoreAccount;
import com.sensiblemetrics.api.alpenidos.core.adapter8.model.AbstractAccount;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Our adapter class.
 * <p>
 * AbstractAccount is the class we are adapting to - we extend from this class.
 * <p>
 * OffshoreAccount is the class we are adapting from - we wrap this class.
 * <p>
 */
public class AccountAdapter extends AbstractAccount {

    /**
     * The class we are adapting from
     */
    private final OffshoreAccount classBeingAdapted;

    /**
     * Constructor takes the class we are going to adapt as an argument.
     *
     * @param offShoreAccount the 3rd party API class we are going to adapt from.
     */
    public AccountAdapter(OffshoreAccount offShoreAccount) {
        // pull the class into out hierarchy by adapting the diff methods names
        super(offShoreAccount.getGrossBalance(), offShoreAccount.canHaveNegativeBalance());

        // keep a reference to it for later
        this.classBeingAdapted = offShoreAccount;
    }

    /**
     * For the offshore account, we have to deduct the tax owed for that country when making the balance calculation.
     */
    @Override
    public BigDecimal getBalance() {
        // get the tax hit from our adapted class
        final BigDecimal taxRate = classBeingAdapted.getOffshoreTaxRate();
        final BigDecimal grossBalance = super.getBalance();

        final BigDecimal taxableBalance = grossBalance.multiply(taxRate);

        return grossBalance.subtract(taxableBalance, MathContext.DECIMAL32);
    }
}
