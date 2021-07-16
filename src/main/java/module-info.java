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
/*
 * @author: Alexander Rogalskiy
 * @title: Design Patterns with Java
 * @link: https://github.com/AlexRogalskiy/alpenidos-core
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
    requires org.apache.commons.io;
    requires camel.core;
    requires camel.api;
    requires gson;
    requires mongo.java.driver;
    requires spring.tx;
    requires spring.data.commons;
    requires spring.aop;
    requires com.google.guice;
    requires spring.data.jpa;
    requires spring.orm;
    requires aws.java.sdk.dynamodb;
    requires aws.java.sdk.core;
    requires aws.lambda.java.events;
    requires aws.lambda.java.core;
    requires json.simple;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires cyclops.react;
    requires httpasyncclient;
    requires rxjava.apache.http;
    requires rxjava.core;
    requires org.aspectj.runtime;
    requires org.jsoup;
    requires spring.security.core;
    requires spring.security.oauth2;
    requires spring.security.config;
    requires tomcat.embed.core;
    requires spring.core;
    requires mailjet.client;
    requires json;
    requires rollbar.java;
    requires org.apache.httpcomponents.httpclient.fluent;
    requires java.rmi;
    requires camel.core.model;
    requires camel.core.engine;
    requires cglib;
    requires io.vavr;
    requires jdk.unsupported;
}
