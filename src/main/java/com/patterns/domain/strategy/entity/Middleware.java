package com.patterns.domain.strategy.entity;

import com.patterns.common.interfaces.strategy.EntityStrategy;
import com.patterns.domain.enums.EntityEnum;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public abstract class Middleware implements EntityStrategy {

    private Middleware next;

    protected abstract EntityEnum getEntityEnum();

    public static Middleware link(Set<EntityEnum> entityEnumSet,
                                  List<Middleware> chain) {

        Middleware head = null;
        Middleware current = null;

        for (Middleware nextInChain : chain) {
            if(entityEnumSet.contains(nextInChain.getEntityEnum())) {
                if (head == null) {
                    head = nextInChain;
                    current = head;
                } else {
                    current.next = nextInChain;
                    current = nextInChain;
                }
            }
        }

        return head;
    }

    protected Optional<Middleware> getNext(){
        if(next == null) return Optional.empty();

        return Optional.of(next);
    }

}

//The ... syntax in Java is called varargs (variable-length arguments).
// It allows you to pass a variable number of arguments of the same type to a method.
// Internally, the arguments are treated as an array.

