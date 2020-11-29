package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter() {
		MemberExporterImpl exportImpl = new MemberExporterImpl();
		return exportImpl;
	}

	@Override
	protected MemberImporter getMemberImporter() {
		MemberImporterImpl importImpl = new MemberImporterImpl();
		return importImpl;
	}

	@Override
	protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
		List<String> noDuplicateID = new ArrayList<String>();
		List<Member> noDuplicate = new ArrayList<Member>();
		for (Member member : membersFromFile) {
			if (!noDuplicateID.contains(member.getId())) {
				noDuplicateID.add(member.getId());
				noDuplicate.add(member);
			}

		}

		return noDuplicate;
	}

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
		HashMap<String, List<Member>> spliteByState = new HashMap<String, List<Member>>();
		for (Member member : validMembers) {
			List<Member> values = new ArrayList<Member>();
			if (spliteByState.containsKey(member.getState())) {
				values = new ArrayList<Member>(spliteByState.get(member.getState()));
			} 
//			else {
//				Member Header_member = new Member();
//				Header_member.setId("Id");
//				Header_member.setAddress("Address");
//				Header_member.setCity("City");
//				Header_member.setFirstName("First_Name");
//				Header_member.setLastName("Last_Name");
//				Header_member.setZip("Zip");
//				Header_member.setState(member.getState());
//				values.add(Header_member);
//			}
			values.add(member);
			spliteByState.merge(member.getState(), values, (oldvalue, newvalue) -> newvalue);

		}
		return spliteByState;
	}

	public static void main(String[] args) {
		File inputFile = new File("Members.txt");

		Main obj = new Main();
		try {
			obj.convert(inputFile, "./output", "outputFile.csv");
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

}
