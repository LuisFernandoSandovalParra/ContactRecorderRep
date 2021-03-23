package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

public class ConstantsGUI {

// JMainFrame
	public static final String TITLE_APP = "Contactos ::: LFSP";
	public static final Dimension DIMENSION_FRAME = new Dimension(600, 500);

// JMainPanel
	public static final String IMG_MAIN_IMAGE = "/img/mainImage.png";
	public static final String IMG_DIAGRAM_ICON = "/img/diagram.png";
	public static final String IMG_LIST_ICON = "/img/address.png";
	public static final String IMG_DELETE_ICON = "/img/delete.png";
	public static final String IMG_SEARCH_ICON = "/img/search.png";
	public static final String IMG_ADD_ICON = "/img/plus.png";
	public static final String IMG_HOME_ICON = "/img/home.png";
	public static final EmptyBorder BASE_BORDER_PANEL = new EmptyBorder(2, 2, 2, 2);
	public static final String DESC_INFO_RECORD = "Ver informacion";
	public static final String DESC_LIST_CONTACT = "Ver contactos";
	public static final String DESC_DELETE_CONTACT = "Eliminar contacto";
	public static final String DESC_FIND_CONTACT = "Buscar contacto";
	public static final String DESC_ADD_CONTACT = "Añadir contacto";
	public static final String DESC_START = "Inicio";
	public static final Color BLUE_DARK_COLOR_BTNS = Color.decode("#94CCEB");
	public static final Color ORANGE_COLOR_BTNS = Color.decode("#F0B873");
	public static final Color BLUE_LIGHT_COLOR_BTNS = Color.decode("#EBFAFC");
	public static final Color VEIGE_BASE_COLOR = Color.decode("#FFFBD0");

// JPanelAddContact
	public static final String TEXT_LABEL_EMAIL = "E-mail: ";
	public static final String TEXT_LABEL_PHONE = "Telefono: ";
	public static final String TEXT_LABEL_NAME = "Nombre: *";
	public static final String TITLE_ADD_PANEL = "AÑADIR CONTACTO";
	public static final String IMG_TICK_ICON = "/img/tick.png";
	public static final String IMG_TRASH_ICON = "/img/trash.png";
	public static final EmptyBorder BORDER_ACCEPT_OR_CANCEL_BTN = new EmptyBorder(0, 15, 15, 15);
	public static final EmptyBorder BORDER_FORMULARY = new EmptyBorder(80, 15, 80, 15);
	public static final Font FONT_TITLE_PANEL = new Font("Roboto", Font.BOLD, 30);
	public static final EmptyBorder BORDER_TITLE_PANEL = new EmptyBorder(15, 0, 0, 0);
	public static final Font FONT_FORMULARY_LABELS = new Font("Roboto", Font.PLAIN, 20);
	public static final Font FONT_FORMULARY_TITLE_LABELS = new Font("Roboto", Font.BOLD, 20);
	public static final Font FONT_FORMULARY_INFO_TREE = new Font("Roboto", Font.PLAIN, 13);
	public static final String DESC_CLEAR_FORM = "Limpiar espacios";
	public static final Color GREEN_ACCEPT_BTNS = Color.decode("#A8E0CF");
	public static final Color GREEN_DARK_ACCEPT_BTNS = Color.decode("#3FB448");
	public static final Color RED_CANCEL_BTNS = Color.decode("#D22026");

// JPanelFindContact
	public static final String TITLE_FIND_CONTACT = "BUSCAR CONTACTO";
	public static final String SYMBOL_EMPTY = "-";

// JPanelDeleteContact
	public static final EmptyBorder BORDER_DELETE_FORMULARY = new EmptyBorder(130, 15, 130, 15);
	public static final String TITLE_DELETE_CONTACT = "BORRAR CONTACTO";

// JPanelListContact
	public static final String EMPTY_STRING = "";
	public static final String JUMP_LINE = "\n";
	public static final EmptyBorder BORDER_CONTAINER_LIST = new EmptyBorder(0, 15, 15, 15);
	public static final String TITLE_CONTACT_PANEL = "CONTACTOS";

// JPanelInfoContactRecord
	public static final String TEXT_NUM_CONTACT_LABEL = "Numero contactos: ";
	public static final String TEXT_MAJOR_CONTACT_LABEL = "Contacto mayor: ";
	public static final String TEXT_MINOR_CONTACT_LABEL = "Contacto menor: ";
	public static final String TITLE_INFO_PANEL = "INFORMACION REGISTRO";
}
