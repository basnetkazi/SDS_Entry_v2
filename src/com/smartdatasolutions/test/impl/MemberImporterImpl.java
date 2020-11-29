package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) throws Exception {

		/*
		 * Implement the missing logic
		 */
//@arunkr.basnet: Implemented the missing logic
		List<Member> memberList = new ArrayList<Member>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
//@arunkr.basnet: Updated the while loop to do while as this looked like a better option
			do {
				line = br.readLine();
				if (line != null) {
//@arunkr.basnet: used the direct substring statement on setter function instead of creating variables on each loop
//@arunkr.basnet: variables used during development stage for testing
//					String id = line.substring(0, 12).trim();
//					String last_name = line.substring(12, 37).trim();
//					String first_name = line.substring(37, 62).trim();
//					String address = line.substring(62, 92).trim();
//					String city = line.substring(92, 112).trim();
//					String state = line.substring(112, 116).trim();
//					String zip = line.substring(116, 121).trim();
//@arunkr.basnet trimmed to remove the extra white spaces from the data
					Member member = new Member();
					member.setId(line.substring(0, 12).trim());
					member.setAddress(line.substring(62, 92).trim());
					member.setCity(line.substring(92, 112).trim());
					member.setFirstName(line.substring(37, 62).trim());
					member.setLastName(line.substring(12, 37).trim());
					member.setZip(line.substring(116, 121).trim());
					member.setState(line.substring(112, 116).trim());
					memberList.add(member);

				}
			} while (line != null);

		}

		return memberList;
	}

}
