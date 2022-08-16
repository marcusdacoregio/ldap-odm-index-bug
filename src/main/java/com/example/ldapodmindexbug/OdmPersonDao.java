package com.example.ldapodmindexbug;

import javax.naming.ldap.LdapName;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class OdmPersonDao {

	private final LdapTemplate ldapTemplate;

	public OdmPersonDao(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public Person findByPrimaryKey(String country, String company, String fullname) {
		LdapName dn = buildDn(country, company, fullname);
		return this.ldapTemplate.findByDn(dn, Person.class);
	}

	private LdapName buildDn(String country, String company, String fullname) {
		return LdapNameBuilder.newInstance().add("dc", "io").add("dc", "spring").add("c", country).add("ou", company).add("cn", fullname).build();
	}

}
