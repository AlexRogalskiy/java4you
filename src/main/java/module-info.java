/*
 * The MIT License
 *
 * Copyright 2019 SensibleMetrics Labs, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
open module com.sensiblemetrics.api.alpenidos.core {
    requires static lombok;
    requires slf4j.api;
    requires com.google.common;
    requires org.apache.commons.lang3;
    requires commons.collections;
    requires java.sql;
    requires java.compiler;
    requires java.naming;
    requires org.apache.commons.codec;
    requires java.desktop;
    requires org.joda.time;
    requires org.apache.commons.text;
    requires java.instrument;
    requires junit;
    requires jsr305;
    requires spring.web;
    requires org.apache.httpcomponents.httpclient;
    requires spring.context;
    requires org.apache.httpcomponents.httpcore;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires mysql.connector.java;
    requires spring.beans;
    requires com.h2database;
    requires guice;
    requires org.apache.commons.io;
    requires camel.core;
    requires camel.api;
}
