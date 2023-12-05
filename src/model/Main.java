package model;
import java.util.ArrayList;
import java.util.List;

import basic_gui.BasicInterface;
import model.entities.Royal;
import model.entities.Targaryen;
import model.enums.GenderEnum;
import model.services.TargaryenService;

public class Main {

	// Enables/disables debugging messages
	public static Boolean debugMode = false;
	
	// Enables/disables fancy JFrame window for viewing the lineages
	public static Boolean interfaceMode = false;
	
	// Pointer to GUI
	public static BasicInterface basicInterface;
	
	// Enables/disables full lineage viewing
	public static Boolean fullLineage = false;

	/*
	 * Concepts and acronyms: 
	 * 	Recursive: Technique for scanning generic tree [size,
	 * 				depth, any shape]
	 * 	DP: Direct Primogeniture
	 * 	DMP: Direct Male Primogeniture
	 * 	LoD: Line of Descent
	 */

	public static void main(String[] args) throws Exception {
		//TudorService.generateTudorLineage();
		//WindsorService.getCurrentRoyalFamily();
		TargaryenService.getTargaryens();
	}

	public static Royal findHeirDP(Royal root) {

		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		Royal heir = root;

		for (Royal r : root.getChildren()) {
			if (r.canBeHeir()) {
				heir = r;
				break;
			} else {
				heir = findHeirDP(r);
				break;
			}
		}

		if (heir == root) {
			List<Royal> heirsAux = root.getRoyalParent().getChildren();
			int index = heirsAux.indexOf(root);
			if (index + 1 < heirsAux.size()) {
				Royal nextRoot = heirsAux.get(index + 1);
				// System.out.println(nextRoot.getName());
				if (nextRoot.canBeHeir()) {
					heir = nextRoot;
				} else {
					heir = findHeirDP(nextRoot);
				}
			} else {

				Royal nextLevel = root.getRoyalParent();
				if (nextLevel != null && nextLevel.getRoyalParent() != null) {
					heirsAux = nextLevel.getRoyalParent().getChildren();
					/*
					 * System.out.println(nextLevel.getName() + "'s kin: " +
					 * heirsAux);
					 */
					int index1 = heirsAux.indexOf(nextLevel);
					// System.out.println(index1);
					if (index1 + 1 < heirsAux.size()) {
						Royal nextRoot = heirsAux.get(index1 + 1);
						// System.out.println(nextRoot.getName());
						if (nextRoot.canBeHeir()) {
							heir = nextRoot;
						} else {
							heir = findHeirDP(nextRoot);
						}
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
			// completar se n�o houverem irm�os v�lidos, subindo at� achar
		}

		return heir;
	}

	public static ArrayList<Royal> findHeirRecursiveDP(Royal root) {

		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		ArrayList<Royal> result = new ArrayList<Royal>();
		List<Royal> heirs = root.getChildren();

		result.add(root);

		for (int j = 0; j < heirs.size(); j++) {
			if (heirs.get(j).getRoyalParent() == null) {
				heirs.get(j).setRoyalParent(root);
			}
			if (!heirs.get(j).getVisited()) {
				ArrayList<Royal> children = findHeirRecursiveDP(heirs.get(j));
				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
					}
				}
			}
		}

		ArrayList<Royal> kin = root.getKin();

		for (int j = 0; j < kin.size(); j++) {
			if (!kin.get(j).getVisited()) {
				ArrayList<Royal> children = findHeirRecursiveDP(kin.get(j));
				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
					}
				}
			}
		}

		Royal parent = root.getRoyalParent();

		if (parent != null) {

			ArrayList<Royal> uncles = parent.getKin();

			if (debugMode) {
				System.out.println("Parent: " + parent.getName());
				System.out.println(uncles);
			}

			for (int j = 0; j < uncles.size(); j++) {
				if (!uncles.get(j).getVisited()) {
					ArrayList<Royal> unclesChildren = findHeirRecursiveDP(uncles
							.get(j));
					for (int k = 0; k < unclesChildren.size(); k++) {
						Royal child = unclesChildren.get(k);
						if (!result.contains(child) && child.canBeHeir()) {
							result.add(child);
						}
					}
				}
			}
		}

		return result;
	}

	public static Royal findHeirDMP(Royal root) {

		root.sortChildrenMaleFirstDob();
		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		Royal heir = root;

		for (Royal r : root.getMaleChildren()) {
			if (r.canBeHeir()) {
				heir = r;
				break;
			} else {
				heir = findHeirDMP(r);
				break;
			}
		}

		if (heir == root) {
			for (Royal r : root.getFemaleChildren()) {
				if (r.canBeHeir()) {
					heir = r;
					break;
				} else {
					heir = findHeirDMP(r);
					break;
				}
			}
		}

		if (heir == root) {
			List<Royal> heirsAux = root.getRoyalParent().getChildren();
			if (debugMode)
				System.out.println("[DEBUG] Kin of root: " + heirsAux);
			int index = heirsAux.indexOf(root);
			if (index + 1 < heirsAux.size()) {
				Royal nextRoot = heirsAux.get(index + 1);
				// System.out.println(nextRoot.getName());
				if (nextRoot.canBeHeir()) {
					heir = nextRoot;
				} else {
					heir = findHeirDMP(nextRoot);
				}
			} else {

				Royal nextLevel = root.getRoyalParent();
				if (nextLevel != null && nextLevel.getRoyalParent() != null) {
					heirsAux = nextLevel.getRoyalParent().getChildren();
					/*
					 * System.out.println(nextLevel.getName() + "'s kin: " +
					 * heirsAux);
					 */

					int index1 = heirsAux.indexOf(nextLevel);
					// System.out.println(index1);
					if (index1 + 1 < heirsAux.size()) {
						Royal nextRoot = heirsAux.get(index1 + 1);
						// System.out.println(nextRoot.getName());
						if (nextRoot.canBeHeir()) {
							heir = nextRoot;
						} else {
							heir = findHeirDMP(nextRoot);
						}
					} else {
						nextLevel = nextLevel.getRoyalParent();
						if (nextLevel != null
								&& nextLevel.getRoyalParent() != null) {
							heirsAux = nextLevel.getRoyalParent().getChildren();
							/*
							 * System.out.println(nextLevel.getName() +
							 * "'s kin: " + heirsAux);
							 */

							index1 = heirsAux.indexOf(nextLevel);
							// System.out.println(index1);
							if (index1 + 1 < heirsAux.size()) {
								Royal nextRoot = heirsAux.get(index1 + 1);
								// System.out.println(nextRoot.getName());
								if (nextRoot.canBeHeir()) {
									heir = nextRoot;
								} else {
									heir = findHeirDMP(nextRoot);
								}
							} else {
								return null;
							}
						} else {
							return null;
						}
					}
				} else {
					return null;
				}
			}
			// completar se n�o houverem irm�os v�lidos, subindo at� achar
		}

		return heir;
	}

	public static ArrayList<Royal> findHeirRecursiveDMP(Royal root) {

		if (root instanceof Targaryen) {
			root = (Targaryen) root;
		}

		// root.sortChildrenMaleFirstDob();

		if (debugMode)
			System.out.println("[DEBUG] Root: " + root.getName());

		ArrayList<Royal> result = new ArrayList<Royal>();
		List<Royal> heirs = root.getChildren();

		result.add(root);
		root.setVisited(true);

		for (int j = 0; j < heirs.size(); j++) {
			if (heirs.get(j).getRoyalParent() == null) {
				heirs.get(j).setRoyalParent(root);
			}
			if (!heirs.get(j).getVisited()) {
				// heirs.get(j).setVisited(true);

				ArrayList<Royal> children = findHeirRecursiveDMP(heirs.get(j));

				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
						// child.setVisited(true);
					}
				}
			}
		}

		ArrayList<Royal> kin = root.getKin();

		for (int j = 0; j < kin.size(); j++) {
			if (!kin.get(j).getVisited()) {
				// kin.get(j).setVisited(true);
				ArrayList<Royal> children = findHeirRecursiveDMP(kin.get(j));
				for (int k = 0; k < children.size(); k++) {
					Royal child = children.get(k);
					if (!result.contains(child) && child.canBeHeir()) {
						result.add(child);
					}
				}
			}
		}

		Royal parent = root.getRoyalParent();

		if (parent != null) {

			ArrayList<Royal> uncles = parent.getKin();

			if (debugMode) {
				System.out.println("Parent: " + parent.getName());
				System.out.println(uncles);
			}
			for (int j = 0; j < uncles.size(); j++) {
				if (!uncles.get(j).getVisited()) {
					// uncles.get(j).setVisited(true);
					ArrayList<Royal> unclesChildren = findHeirRecursiveDMP(uncles
							.get(j));
					for (int k = 0; k < unclesChildren.size(); k++) {
						Royal child = unclesChildren.get(k);
						/*
						 * if (child.getRoyalParent() == null){
						 * child.setRoyalParent(uncles.get(j)); }
						 */
						if (!result.contains(child) && child.canBeHeir()) {
							result.add(child);
						}
					}
				}
			}
		}

		return result;
	}

	public static void getLoDDP(Royal root) {
		Royal h = root;
		Royal aux;
		int i = 0;
		String message = "\nLine of descent of " + root.getName() + ":\n";
		do {
			i++;
			aux = findHeirDP(h);
			if (aux != null) {
				message += i + ". " + aux.getName() + "\n";
			}
			h = aux;
		} while (aux != null);
		System.out.println(message);
	}

	public static void getRecursiveLoDDP(Royal root) throws Exception {
		Royal h = root;
		String title = "\nLine of descent of " + root.getName() + ":\n";
		String message = "";
		String messageAux = "";
		ArrayList<Royal> lineage = new ArrayList<Royal>();
		lineage = findHeirRecursiveDP(h);
		if (lineage.size() <= 12) {
			for (int i = 1; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			System.out.println(title);
			System.out.println(message);
		} else {
			for (int i = 1; i <= 12; i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			message += "\n";
			for (int i = 13; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				messageAux += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					messageAux += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
				if (i % 12 == 0 && !interfaceMode) {
					messageAux += "\n";
				}
			}
			System.out.println(title);
			System.out.println(message + messageAux);
		}

		if (interfaceMode) {
			basicInterface = new BasicInterface();
			basicInterface.showLineage(message, messageAux, title);
			basicInterface.setVisible(true);
		}
	}

	public static void getLoDDMP(Royal root) throws Exception {
		Royal h = root;
		Royal aux;
		int i = 0;
		String message = "\nLine of descent of " + root.getName() + ":\n";
		do {
			i++;
			aux = findHeirDMP(h);
			if (aux != null) {
				message += i + ". " + aux.getName() + "\n";
			}
			h = aux;
		} while (aux != null);
		System.out.println(message);
	}

	public static void getRecursiveLoDDMP(Royal root) throws Exception {
		Royal h = root;
		String title = "\nLine of descent of " + root.getName() + ":\n";
		String message = "";
		String messageAux = "";
		ArrayList<Royal> lineage = new ArrayList<Royal>();
		lineage = findHeirRecursiveDMP(h);
		if (lineage.size() <= 12) {
			for (int i = 1; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			System.out.println(title);
			System.out.println(message);
		} else {
			for (int i = 1; i <= 12; i++) {
				Royal aux = lineage.get(i);
				message += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					message += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
			}
			message += "\n";
			for (int i = 13; i < lineage.size(); i++) {
				Royal aux = lineage.get(i);
				messageAux += i + ". " + aux.getName() + "\n";
				if (aux.getRoyalParent() != null && debugMode) {
					messageAux += "Parent: " + aux.getRoyalParent().getName()
							+ "\n";
				}
				if (i % 12 == 0 && !interfaceMode) {
					messageAux += "\n";
				}
			}
			System.out.println(title);
			System.out.println(message + messageAux);
		}
		if (interfaceMode) {
			basicInterface = new BasicInterface();
			basicInterface.showLineage(message, messageAux, title);
			basicInterface.setVisible(true);
		}
	}

	@SuppressWarnings("unused")
	private static String showHeirDP(Royal root) {
		Royal heir = findHeirDP(root);
		String message = "";
		if (heir != root && heir != null) {
			message = "Heir to " + root.getName() + ": HRH Prince";
			if (heir.getGender() == GenderEnum.FEMALE) {
				message += "ss";
			}
			message += " " + heir.getName();
		} else {
			message = "No heirs!";
		}
		return message;
	}

	@SuppressWarnings("unused")
	private static String showHeirDMP(Royal root) {
		Royal heir = findHeirDMP(root);
		String message = "";
		if (heir != root && heir != null) {
			message = "Heir to " + root.getName() + ": HRH Prince";
			if (heir.getGender() == GenderEnum.FEMALE) {
				message += "ss";
			}
			message += " " + heir.getName();
		} else {
			message = "No heirs!";
		}
		return message;
	}

}
