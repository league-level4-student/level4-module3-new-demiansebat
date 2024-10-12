package _01_Spies_On_A_Train;

import java.util.HashMap;
import java.util.Map.Entry;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency!
	 * You know the spy is somewhere on this train(LinkedList). Your job is to
	 * find the suspect that matches the description given to you by the list of
	 * clues(the array).
	 * 
	 * Walk through the train, questioning each of the passengers about what
	 * they have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {
int greatest = 0;
String name=null;
		HashMap<String,Integer> counts= new HashMap<>();


		Node<TrainCar> n = train.getHead();
		while(n!=null) {

			String response =n.getValue().questionPassenger();
			for(String e:clues) {
				
				if(response.contains(e)) {
					String[] words=response.split(" ");
					if(counts.containsKey(words[13])) {
						counts.put(words[13], counts.get(words[13]) + 1  );
					}else {
						counts.put(words[13],1);
					}
				}
			}
		
		 

			n=n.getNext();
		}
		System.out.println(counts.entrySet().size() + " ****************");
		for(Entry<String,Integer>entry:counts.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			if(entry.getValue()>greatest) {
				greatest=entry.getValue();
				name=entry.getKey();
			}
		}
		return name;

	}

}
