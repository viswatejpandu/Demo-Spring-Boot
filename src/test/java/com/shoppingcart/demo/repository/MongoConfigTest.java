/*
 * $Id$
 *
 * Copyright (C). All Right Reserved.
 *
 * Copyright in the whole or any part of this document belongs to Harish
 * Limited and it must be kept strictly confidential by the recipient and
 * must not be used, sold, licensed, transferred, copied or reproduced in
 * whole or in any part in any manner or form or on any media to any person
 * without the prior written consent of Harish.
 */
package com.shoppingcart.demo.repository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

/*
 * MongoConfigTest: Toggle between local test DB and DevnetTest test DB
 * 
 * @PropertySource("classpath:mongoconfigXXXXX") use either: mongoconfiglocaltest.properties
 * 
 */
@EnableMongoRepositories({"com.shoppingcart.demo.repository"})
@ComponentScan(basePackages = {"com.shoppingcart.demo.*"})
@PropertySource("classpath:mongolocaltest.properties")
public class MongoConfigTest extends AbstractMongoConfiguration {

  @Value("${mongodb.database}")
  private String database;
  @Value("${mongodb.url}")
  private String url;
  @Value("${mongodb.port}")
  private int port;
  @Value("${mongodb.username}")
  private String username;
  @Value("${mongodb.password}")
  private String password;


  @Override
  protected String getDatabaseName() {
    return database;
  }

  @Override
  public Mongo mongo() throws Exception {

    MongoCredential credential =
        MongoCredential.createScramSha1Credential(username, database, password.toCharArray());
    Mongo mongo = new MongoClient(getServerAddresses(), Arrays.asList(credential));
    mongo.setWriteConcern(WriteConcern.SAFE);
    return mongo;
  }

  private ArrayList<ServerAddress> getServerAddresses() throws UnknownHostException {
    ArrayList<ServerAddress> serverAdressses = new ArrayList<ServerAddress>();
    for (String s : url.split(",")) {
      serverAdressses.add(new ServerAddress(s));
    }
    return serverAdressses;
  }

  @Override
  @Bean(name = "template")
  public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongo(), getDatabaseName());
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}


