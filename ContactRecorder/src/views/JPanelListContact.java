package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class JPanelListContact extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea listArea;

	public JPanelListContact() {
		setLayout(new BorderLayout());
		setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		initComponents();
	}

	private void initComponents() {
		createShowListTitle();
		createSpaceList();
	}

	private void createShowListTitle() {
		JLabel titleDeleteSpace = new JLabel(ConstantsGUI.TITLE_CONTACT_PANEL);
		titleDeleteSpace.setBorder(ConstantsGUI.BORDER_TITLE_PANEL);
		titleDeleteSpace.setHorizontalAlignment(SwingConstants.CENTER);
		titleDeleteSpace.setFont(ConstantsGUI.FONT_TITLE_PANEL);
		add(titleDeleteSpace, BorderLayout.NORTH);
	}

	private void createSpaceList() {
		JPanel containerListPanel = new JPanel();
		containerListPanel.setBackground(ConstantsGUI.BLUE_DARK_COLOR_BTNS);
		containerListPanel.setLayout(new BorderLayout());
		containerListPanel.setBorder(ConstantsGUI.BORDER_CONTAINER_LIST);
		listArea = new JTextArea();
		listArea.setBackground(ConstantsGUI.VEIGE_BASE_COLOR);
		listArea.setEditable(false);
		JScrollPane pScroll = new JScrollPane(listArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		containerListPanel.add(pScroll, BorderLayout.CENTER);
		add(containerListPanel, BorderLayout.CENTER);
	}

	public void setListContact(ArrayList<String> contactList) {
		String contactLine = ConstantsGUI.EMPTY_STRING;
		for (int i = 0; i < contactList.size(); i++) {
			contactLine += contactList.get(i) + ConstantsGUI.JUMP_LINE;
		}
		listArea.setText(contactLine);
	}
}
