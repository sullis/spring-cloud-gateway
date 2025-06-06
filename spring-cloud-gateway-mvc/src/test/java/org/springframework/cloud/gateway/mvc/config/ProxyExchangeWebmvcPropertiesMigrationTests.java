/*
 * Copyright 2013-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.gateway.mvc.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")
@SpringBootTest(properties = {}, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("propertiesmigrationtests")
public class ProxyExchangeWebmvcPropertiesMigrationTests {

	@Autowired
	ProxyExchangeWebMvcProperties properties;

	@Test
	public void deprecatedRoutePropertiesWork() {
		assertThat(properties.getHeaders()).hasSize(2);
		assertThat(properties.getAutoForward()).hasSize(2);
		assertThat(properties.getSensitive()).hasSize(2);
		assertThat(properties.getSkipped()).hasSize(3);
	}

	@SpringBootConfiguration
	@EnableAutoConfiguration
	protected static class TestConfiguration {

	}

}
