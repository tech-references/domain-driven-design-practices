package me.bigfanoftim.domaindriven.temp.common.jpa;

import jakarta.persistence.AttributeConverter;
import me.bigfanoftim.domaindriven.temp.common.model.Money;


/**
 * autoApply를 true로 설정하면 모든 Money 타입의 프로퍼티에 자동으로 이 컨버터를 적용한다.
 * @Converter(autoApply = true)
 */
public class MoneyConverter implements AttributeConverter<Money, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Money money) {
        return money == null ? null : money.getValue();
    }

    @Override
    public Money convertToEntityAttribute(Integer value) {
        return value == null ? null : new Money(value);
    }
}
