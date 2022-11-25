package me.day15.smartstore.groups;

public class Groups { // 싱글톤
	private static Groups allGroups;
	private Group[] groups;

	private Groups() {}
	public static Groups getInstance() {
		if (allGroups == null) {
			allGroups = new Groups();
		}
		return allGroups;
	}
}
