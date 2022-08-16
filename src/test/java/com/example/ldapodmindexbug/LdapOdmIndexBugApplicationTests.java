package com.example.ldapodmindexbug;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LdapOdmIndexBugApplicationTests {

	@Autowired
	private OdmPersonDao odmPersonDao;

	@Test
	void findByPrimaryKeyShouldReturnCorrectFields() {
		Person person = this.odmPersonDao.findByPrimaryKey("Sweden", "company1", "Some Person");
		assertThat(person.getCompany()).isEqualTo("company1");
		assertThat(person.getCountry()).isEqualTo("Sweden");
		assertThat(person.getFullName()).isEqualTo("Some Person");
		assertThat(person.getLastName()).isEqualTo("Person");
		assertThat(person.getDescription()).isEqualTo("Sweden, Company1, Some Person");
		assertThat(person.getPhone()).isEqualTo("+46 555-123456");
	}

}
