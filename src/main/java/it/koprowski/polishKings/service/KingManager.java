package it.koprowski.polishKings.service;

import it.koprowski.polishKings.domain.King;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KingManager {
	private List<King> database = new ArrayList<King>();

	public void addKing(King _king) {
		King newKing = new King();

		newKing.setName(_king.getName());
		newKing.setAuthorsEmail(_king.getAuthorsEmail());
		newKing.setStartOfRule(_king.startOfRule);
		newKing.setEndOfRule(_king.endOfRule);
		newKing.setNumOfChildren(_king.getNumOfChildren());

		database.add(newKing);
	}

	/*
	// Removes the person with given PIN
	public void removeKing(King _king) {
		King kingToRemove = null;
		for (King k : database) {
			if (_king.getPin().equals(k.getPin())) {
				kingToRemove = k;
				break;
			}
		}
		if (kingToRemove != null)
			database.remove(kingToRemove);
	}
*/
	public List<King> getAllKings() {
		return database;
	}

	public void removeKing(King kingToDelete) {
		database.remove(kingToDelete);
		
	}
}
