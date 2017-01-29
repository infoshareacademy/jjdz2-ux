package com.sionach.ux.color;

import com.sionach.ux.filemanagment.ReadFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CreateNamesHexListFromFile {

    private static final Logger LOGGER = LogManager.getLogger(CreateNamesHexListFromFile.class);

    public List<NamesHexTable> createListOfColorsNames(){
        LOGGER.info("Lista kolorow wczytana");
        List<NamesHexTable> namesHexTableList = new ArrayList<>();
        namesHexTableList.add(new NamesHexTable("AliceBlue" , "f0f8ff"));
        namesHexTableList.add(new NamesHexTable("AntiqueWhite" , "faebd7"));
        namesHexTableList.add(new NamesHexTable("Aqua", "00ffff"));
        namesHexTableList.add(new NamesHexTable("Aquamarine" , "7fffd4"));
        namesHexTableList.add(new NamesHexTable("Azure" , "f0ffff"));
        namesHexTableList.add(new NamesHexTable("Beige" , "f5f5dc"));
        namesHexTableList.add(new NamesHexTable("Bisque" , "ffe4c4"));
        namesHexTableList.add(new NamesHexTable("Black" , "000000"));
        namesHexTableList.add(new NamesHexTable("BlanchedAlmond" , "ffebcd"));
        namesHexTableList.add(new NamesHexTable("Blue" , "0000ff"));
        namesHexTableList.add(new NamesHexTable("BlueViolet" , "8a2be2"));
        namesHexTableList.add(new NamesHexTable("Brown" , "a52a2a"));
        namesHexTableList.add(new NamesHexTable("BurlyWood" , "deb887"));
        namesHexTableList.add(new NamesHexTable("CadetBlue" , "5f9ea0"));
        namesHexTableList.add(new NamesHexTable("Chartreuse" , "7fff00"));
        namesHexTableList.add(new NamesHexTable("Chocolate" , "d2691e"));
        namesHexTableList.add(new NamesHexTable("Coral" , "ff7f50"));
        namesHexTableList.add(new NamesHexTable("CornflowerBlue" , "6495ed"));
        namesHexTableList.add(new NamesHexTable("Cornsilk" , "fff8dc"));
        namesHexTableList.add(new NamesHexTable("Crimson" , "dc143c"));
        namesHexTableList.add(new NamesHexTable("Cyan" , "00ffff"));
        namesHexTableList.add(new NamesHexTable("DarkBlue" , "00008b"));
        namesHexTableList.add(new NamesHexTable("DarkCyan" , "008b8b"));
        namesHexTableList.add(new NamesHexTable("DarkGoldenRod" ,"b8860b"));
        namesHexTableList.add(new NamesHexTable("DarkGray" , "a9a9a9"));
        namesHexTableList.add(new NamesHexTable("DarkGrey" , "a9a9a9 "));
        namesHexTableList.add(new NamesHexTable("DarkGreen" , "006400"));
        namesHexTableList.add(new NamesHexTable("DarkKhaki" , "bdb76b"));
        namesHexTableList.add(new NamesHexTable("DarkMagenta" , "8b008b"));
        namesHexTableList.add(new NamesHexTable("DarkOliveGreen","556b2f"));
        namesHexTableList.add(new NamesHexTable("DarkOrange", "ff8c00"));
        namesHexTableList.add(new NamesHexTable("DarkOrchid","9932cc"));
        namesHexTableList.add(new NamesHexTable("DarkRed", "8b0000"));
        namesHexTableList.add(new NamesHexTable("DarkSalmon", "e9967a"));
        namesHexTableList.add(new NamesHexTable("DarkSeaGreen" ,"8fbc8f"));
        namesHexTableList.add(new NamesHexTable("DarkSlateBlue","483d8b"));
        namesHexTableList.add(new NamesHexTable("DarkSlateGray" , "2f4f4f"));
        namesHexTableList.add(new NamesHexTable("DarkSlateGrey" , "2f4f4f"));
        namesHexTableList.add(new NamesHexTable("DarkTurquoise" , "00ced1"));
        namesHexTableList.add(new NamesHexTable("DarkViolet" ,"9400d3"));
        namesHexTableList.add(new NamesHexTable("DeepPink", "ff1493"));
        namesHexTableList.add(new NamesHexTable("DeepSkyBlue", "00bfff"));
        namesHexTableList.add(new NamesHexTable("DimGray" ,"696969"));
        namesHexTableList.add(new NamesHexTable("DimGrey" , "696969"));
        namesHexTableList.add(new NamesHexTable("DodgerBlue" , "1e90ff"));
        namesHexTableList.add(new NamesHexTable("FireBrick", "b22222"));
        namesHexTableList.add(new NamesHexTable("FloralWhite" ,"fffaf0"));
        namesHexTableList.add(new NamesHexTable("ForestGreen", "228b22"));
        namesHexTableList.add(new NamesHexTable("Fuchsia" ,"ff00ff"));
        namesHexTableList.add(new NamesHexTable("Gainsboro" ,"dcdcdc"));
        namesHexTableList.add(new NamesHexTable("GhostWhite", "f8f8ff"));
        namesHexTableList.add(new NamesHexTable("Gold", "ffd700"));
        namesHexTableList.add(new NamesHexTable("GoldenRod" , "daa520"));
        namesHexTableList.add(new NamesHexTable("Gray", "808080"));
        namesHexTableList.add(new NamesHexTable("Grey" ,"808080"));
        namesHexTableList.add(new NamesHexTable("Green", "008000"));
        namesHexTableList.add(new NamesHexTable("GreenYellow" , "adff2f"));
        namesHexTableList.add(new NamesHexTable("HoneyDew", "f0fff0"));
        namesHexTableList.add(new NamesHexTable("HotPink", "ff69b4"));
        namesHexTableList.add(new NamesHexTable("IndianRed", "cd5c5c"));
        namesHexTableList.add(new NamesHexTable("Indigo", "4b0082"));
        namesHexTableList.add(new NamesHexTable("Ivory", "fffff0"));
        namesHexTableList.add(new NamesHexTable("Khaki" ,"f0e68c"));
        namesHexTableList.add(new NamesHexTable("Lavender", "e6e6fa"));
        namesHexTableList.add(new NamesHexTable("LavenderBlush", "fff0f5"));
        namesHexTableList.add(new NamesHexTable("LawnGreen" ,"7cfc00"));
        namesHexTableList.add(new NamesHexTable("LemonChiffon", "fffacd"));
        namesHexTableList.add(new NamesHexTable("LightBlue", "add8e6"));
        namesHexTableList.add(new NamesHexTable("LightCoral", "f08080"));
        namesHexTableList.add(new NamesHexTable("LightCyan", "e0ffff"));
        namesHexTableList.add(new NamesHexTable("LightGoldenRodYellow", "fafad2"));
        namesHexTableList.add(new NamesHexTable("LightGray", "d3d3d3"));
        namesHexTableList.add(new NamesHexTable("LightGrey", "d3d3d3"));
        namesHexTableList.add(new NamesHexTable("LightGreen", "90ee90"));
        namesHexTableList.add(new NamesHexTable("LightPink","ffb6c1"));
        namesHexTableList.add(new NamesHexTable("LightSalmon", "ffa07a"));
        namesHexTableList.add(new NamesHexTable("LightSeaGreen", "20b2aa"));
        namesHexTableList.add(new NamesHexTable("LightSkyBlue", "87cefa"));
        namesHexTableList.add(new NamesHexTable("LightSlateGray", "778899"));
        namesHexTableList.add(new NamesHexTable("LightSlateGrey", "778899"));
        namesHexTableList.add(new NamesHexTable("LightSteelBlue", "b0c4de"));
        namesHexTableList.add(new NamesHexTable("LightYellow", "ffffe0"));
        namesHexTableList.add(new NamesHexTable("Lime", "00ff00"));
        namesHexTableList.add(new NamesHexTable("LimeGreen", "32cd32"));
        namesHexTableList.add(new NamesHexTable("Linen", "faf0e6"));
        namesHexTableList.add(new NamesHexTable("Magenta", "ff00ff"));
        namesHexTableList.add(new NamesHexTable("Maroon", "800000"));
        namesHexTableList.add(new NamesHexTable("MediumAquaMarine", "66cdaa"));
        namesHexTableList.add(new NamesHexTable("MediumBlue", "0000cd"));
        namesHexTableList.add(new NamesHexTable("MediumOrchid", "ba55d3"));
        namesHexTableList.add(new NamesHexTable("MediumPurple", "9370db"));
        namesHexTableList.add(new NamesHexTable("MediumSeaGreen", "3cb371"));
        namesHexTableList.add(new NamesHexTable("MediumSlateBlue", "7b68ee"));
        namesHexTableList.add(new NamesHexTable("MediumSpringGreen", "00fa9a"));
        namesHexTableList.add(new NamesHexTable("MediumTurquoise", "48d1cc"));
        namesHexTableList.add(new NamesHexTable("MediumVioletRed", "c71585"));
        namesHexTableList.add(new NamesHexTable("MidnightBlue" ,"191970"));
        namesHexTableList.add(new NamesHexTable("MintCream" ,"f5fffa"));
        namesHexTableList.add(new NamesHexTable("MistyRose", "ffe4e1"));
        namesHexTableList.add(new NamesHexTable("Moccasin", "ffe4b5"));
        namesHexTableList.add(new NamesHexTable("NavajoWhite" ,"ffdead"));
        namesHexTableList.add(new NamesHexTable("Navy", "000080"));
        namesHexTableList.add(new NamesHexTable("OldLace", "fdf5e6"));
        namesHexTableList.add(new NamesHexTable("Olive", "808000"));
        namesHexTableList.add(new NamesHexTable("OliveDrab" ,"6b8e23"));
        namesHexTableList.add(new NamesHexTable("Orange" ,"ffa500"));
        namesHexTableList.add(new NamesHexTable("OrangeRed", "ff4500"));
        namesHexTableList.add(new NamesHexTable("Orchid", "da70d6"));
        namesHexTableList.add(new NamesHexTable("PaleGoldenRod", "eee8aa"));
        namesHexTableList.add(new NamesHexTable("PaleGreen", "98fb98"));
        namesHexTableList.add(new NamesHexTable("PaleTurquoise" ,"afeeee"));
        namesHexTableList.add(new NamesHexTable("PaleVioletRed", "db7093"));
        namesHexTableList.add(new NamesHexTable("PapayaWhip", "ffefd5"));
        namesHexTableList.add(new NamesHexTable("PeachPuff", "ffdab9"));
        namesHexTableList.add(new NamesHexTable("Peru", "cd853f"));
        namesHexTableList.add(new NamesHexTable("Pink", "ffc0cb"));
        namesHexTableList.add(new NamesHexTable("Plum", "dda0dd"));
        namesHexTableList.add(new NamesHexTable("PowderBlue", "b0e0e6"));
        namesHexTableList.add(new NamesHexTable("Purple", "800080"));
        namesHexTableList.add(new NamesHexTable("RebeccaPurple", "663399"));
        namesHexTableList.add(new NamesHexTable("Red", "ff0000"));
        namesHexTableList.add(new NamesHexTable("RosyBrown" ,"bc8f8f"));
        namesHexTableList.add(new NamesHexTable("RoyalBlue", "4169e1"));
        namesHexTableList.add(new NamesHexTable("SaddleBrown", "8b4513"));
        namesHexTableList.add(new NamesHexTable("Salmon", "fa8072"));
        namesHexTableList.add(new NamesHexTable("SandyBrown", "f4a460"));
        namesHexTableList.add(new NamesHexTable("SeaGreen" ,"2e8b57"));
        namesHexTableList.add(new NamesHexTable("SeaShell" ,"fff5ee"));
        namesHexTableList.add(new NamesHexTable("Sienna", "a0522d"));
        namesHexTableList.add(new NamesHexTable("Silver", "c0c0c0"));
        namesHexTableList.add(new NamesHexTable("SkyBlue", "87ceeb"));
        namesHexTableList.add(new NamesHexTable("SlateBlue", "6a5acd"));
        namesHexTableList.add(new NamesHexTable("SlateGray", "708090"));
        namesHexTableList.add(new NamesHexTable("SlateGrey" ,"708090"));
        namesHexTableList.add(new NamesHexTable("Snow", "fffafa"));
        namesHexTableList.add(new NamesHexTable("SpringGreen", "00ff7f"));
        namesHexTableList.add(new NamesHexTable("SteelBlue", "4682b4"));
        namesHexTableList.add(new NamesHexTable("Tan" ,"d2b48c"));
        namesHexTableList.add(new NamesHexTable("Teal" ,"008080"));
        namesHexTableList.add(new NamesHexTable("Thistle", "d8bfd8"));
        namesHexTableList.add(new NamesHexTable("Tomato", "ff6347"));
        namesHexTableList.add(new NamesHexTable("Turquoise" ,"40e0d0"));
        namesHexTableList.add(new NamesHexTable("Violet" ,"ee82ee"));
        namesHexTableList.add(new NamesHexTable("Wheat" ,"f5deb3"));
        namesHexTableList.add(new NamesHexTable("White" ,"ffffff"));
        namesHexTableList.add(new NamesHexTable("WhiteSmoke", "f5f5f5"));
        namesHexTableList.add(new NamesHexTable("Yellow", "ffff00"));
        namesHexTableList.add(new NamesHexTable("YellowGreen", "9acd32"));


        return namesHexTableList;
    }

    public List<NamesHexTable> fileToStringList() {
        LOGGER.debug("Attempt to read the file");
        List<NamesHexTable> namesHexTableList;
        ReadFiles readFile = new ReadFiles();
        List<String> stringList;
        stringList = readFile.readFileToList("tableNamesHex.txt");

        LOGGER.debug("Convert string list into namesHexTable list");
        namesHexTableList = StringListToNamesHexTableList(stringList);

        return namesHexTableList;
    }

    private List<NamesHexTable> StringListToNamesHexTableList(List<String> stringList) {
        LOGGER.debug("Converts list of strings into list of NamesHexTable objects");
        List<NamesHexTable> namesHexTableLists = new ArrayList<>();
        NamesHexTable namesHexTable = new NamesHexTable();
        for (String aStringList : stringList) {
            namesHexTable.splitLineBySpace(aStringList);
            namesHexTableLists.add(new NamesHexTable(namesHexTable.getColorName(), namesHexTable.getColorHex()));
            LOGGER.debug("One string line converted into NamesHexTable object");
        }
        return namesHexTableLists;
    }
}
