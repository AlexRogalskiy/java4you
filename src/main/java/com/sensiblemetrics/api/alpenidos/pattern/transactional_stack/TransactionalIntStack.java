package com.sensiblemetrics.api.alpenidos.pattern.transactional_stack;

import java.util.Stack;

public class TransactionalIntStack implements IntStackTransactional {
    private Stack<TransactionalIntStack> transactions;
    private Stack<Integer> integers;

    @Override
    public int push(final int value) {
        if (this.transactions.empty()) {
            return this.integers.push(value);
        }
        return this.transactions.peek().push(value);
    }

    @Override
    public int pop() {
        if (this.transactions.empty()) {
            return this.integers.pop();
        }
        return this.transactions.peek().pop();
    }

    @Override
    public boolean empty() {
        return this.integers.empty();
    }

    @Override
    public void open() {
        this.transactions.push(new TransactionalIntStack());
    }

    @Override
    public boolean commit() {
        if (!this.transactions.empty()) {
            final TransactionalIntStack lastTransaction = this.transactions.pop();
            return this.transactions.peek().integers.addAll(lastTransaction.integers);
        }
        return false;
    }

    @Override
    public boolean rollback() {
        if (!this.transactions.empty()) {
            this.transactions.pop();
            return true;
        }
        return false;
    }
}
