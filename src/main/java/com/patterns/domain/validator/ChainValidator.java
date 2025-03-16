package com.patterns.domain.validator;

public abstract class ChainValidator<T> {

    private ChainValidator<T> next;

    public ChainValidator<T> linkWith(ChainValidator<T> next) {
        if (this.next == null) {
            this.next = next;
            return this;
        }

        var lastStep = this.next;
        while(lastStep.next != null) {
            lastStep = lastStep.next;
        }

        lastStep.next = next;
        return this;
    }

    public abstract ValidationResult validate(T value);

    protected ValidationResult checkNext(T value) {
        if (next == null) {
            return ValidationResult.valid();
        }

        return next.validate(value);
    }
}
