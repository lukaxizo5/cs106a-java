import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Problem63646566 extends ConsoleProgram{
	public void run() {
		HashMap<String, ArrayList<String>> friendList;
		HashMap<String, Integer> stat; //vis ramdeni emegobreba
		stat = new HashMap<String, Integer>();
		int mostFriends = 0;
		String dudeWithMostFriends = null;
		friendList = new HashMap<String, ArrayList<String>>();
		while (true) {
			String f1 = readLine();
			if (f1.equals("")) break;
			String f2 = readLine();
			if (!friendList.containsKey(f1)) {
				friendList.put(f1, new ArrayList<String>());
			}
			friendList.get(f1).add(f2);
			stat.put(f1, 0);
			stat.put(f2, 0);
		}
		
		for (String friend : friendList.keySet()) {
			if (friendList.get(friend).size() > mostFriends) {
				dudeWithMostFriends = friend;
				mostFriends = friendList.get(friend).size();
			}
			//Problem 64 prints people and their friend list.
			print(friend + ": ");
			println(friendList.get(friend));
		}
		
		//Problem 63 Print who has most friends.
		println("Person with most friends is " + dudeWithMostFriends);
		
		//Problem 65 print how many people are considering this guy as a friend.
		for (String friend : stat.keySet()) {
			for (String friend2 : friendList.keySet()) {
				if (friendList.get(friend2).contains(friend)) {
					stat.put(friend, stat.get(friend) + 1);
				}
			}
		}
		
		for (String friend : stat.keySet()) {
			println(friend + " " + stat.get(friend) );
		}
		
		//Problem 66 prints two people with no friends in common.

		for (String friend : friendList.keySet()) {
			for (String friend2 : friendList.keySet()) {
				if (!matched(friendList.get(friend), friendList.get(friend2))) {
					println(friend + " and " + friend2 + " do not share any friends.");
					return;
				}
			}
		}
		
	}

	private boolean matched(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = 0; j < arrayList2.size(); j++) {
				if (arrayList.get(i).equals(arrayList2.get(j))) return true;
			}
		}
		return false;
	}

}
