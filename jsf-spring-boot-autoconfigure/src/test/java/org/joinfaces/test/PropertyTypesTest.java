/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.joinfaces.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Lars Grefer
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestPropertiesAutoConfiguration.class)
public class PropertyTypesTest {

	private static final String FOO = "foo";
	private static final String BAR = "bar";

	@Autowired
	private TestProperties testProperties;

	@Test
	public void testPropertiesListAProperties() {
		assertThat(testProperties.getListA()).containsExactly(FOO, BAR);
	}

	@Test
	public void testPropertiesListBProperties() {
		assertThat(testProperties.getListB()).containsExactly(FOO, BAR);
	}

	@Test
	public void testYamlListCProperties() {
		assertThat(testProperties.getListC()).containsExactly(FOO, BAR);
	}

	@Test
	public void testYamlListDProperties() {
		assertThat(testProperties.getListD()).containsExactly(FOO, BAR);
	}

	@Test
	public void textCharSequenceClassProperty() {
		assertThat(testProperties.getCharSequenceClass()).isNotNull();
		assertThat(testProperties.getCharSequenceClass()).isEqualTo(String.class);
	}

	@Test
	public void testClassProperty() {
		assertThat(testProperties.getRandomClass()).isNotNull();
		assertThat(testProperties.getRandomClass()).isEqualTo(Void.class);
	}

	@Test
	public void testClassListProperty() {
		assertThat(testProperties.getClassList()).containsExactly(String.class, Void.class, List.class);
	}
}
