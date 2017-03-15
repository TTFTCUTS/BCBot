package ttftcuts.bcbot.util;

import bwapi.Color;
import bwapi.CoordinateType.Enum;
import bwapi.Game;
import bwapi.Position;
import bwta.Polygon;
import ttftcuts.bcbot.Main;

import java.util.Arrays;
import java.util.List;

public final class Drawing {
    private static Game getGame() {
        return Main.bot.theGame;
    }

    public static void drawPolygon(Polygon poly, Color colour, Enum coordinateType) {
        List<Position> points = poly.getPoints();
        int prev = points.size()-1;

        for(int i=0; i<points.size(); i++) {
            Position p1 = points.get(i);
            Position p2 = points.get(prev);
            getGame().drawLine(coordinateType, p1.getX(), p1.getY(), p2.getX(), p2.getY(), colour);
            prev = i;
        }
    }

    public static void drawPolygonMap(Polygon poly, Color colour) {
        drawPolygon(poly, colour, Enum.Map);
    }

    public static void drawPolygonMouse(Polygon poly, Color colour) {
        drawPolygon(poly, colour, Enum.Mouse);
    }

    public static void drawPolygonScreen(Polygon poly, Color colour) {
        drawPolygon(poly, colour, Enum.Screen);
    }

    public static final class Colours {
        public static Color[] palette;

        public static void drawPalette() {
            int tilesize = 16;
            int gap = 3;
            int index;
            int top,left;

            for (int y=0; y<16; y++) {
                for (int x=0; x<16; x++) {
                    index = y * 16 + x;

                    top = y * (tilesize + gap) + gap;
                    left = x * (tilesize + gap) + gap;

                    drawColourSwatch(index, left, top, tilesize,tilesize);
                }
            }
        }

        public static void drawColourSwatch(int index, int x, int y, int w, int h, int textoffset) {
            Drawing.getGame().drawBoxScreen(x, y, x+w, y+h, palette[index], true);
            Drawing.getGame().drawTextScreen(x,y-2+textoffset, ""+index);
        }

        public static void drawColourSwatch(int index, int x, int y, int w, int h) {
            drawColourSwatch(index, x,y,w,h,0);
        }

        public static void drawColourSeries(int ox, int oy, int... colours) {
            int tilesize = 16;
            int gap = 3;

            for (int i=0; i<colours.length; i++) {
                drawColourSwatch(colours[i], ox + i * (tilesize + gap), oy, tilesize, tilesize, -10);
            }
        }

        public static void initPalette() {
            if (palette != null) {
                return;
            }

            palette = new Color[256];
            Arrays.fill(palette, Color.Black);

            palette[0] = new Color(4,2,4);
            palette[16] = new Color(44,38,28);
            palette[17] = new Color(76,38,20);
            palette[18] = new Color(92,46,20);
            palette[19] = new Color(116,50,20);
            palette[20] = new Color(108,62,36);
            palette[21] = new Color(124,66,28);
            palette[22] = new Color(124,78,44);
            palette[23] = new Color(172,10,12);
            palette[24] = new Color(140,86,52);
            palette[25] = new Color(132,98,68);
            palette[26] = new Color(164,86,28);
            palette[27] = new Color(196,78,28);
            palette[28] = new Color(188,106,36);
            palette[29] = new Color(180,114,60);
            palette[30] = new Color(212,102,36);
            palette[31] = new Color(220,150,52);
            palette[32] = new Color(228,150,84);
            palette[33] = new Color(236,198,84);
            palette[34] = new Color(52,70,44);
            palette[35] = new Color(68,110,60);
            palette[36] = new Color(76,110,84);
            palette[37] = new Color(76,130,84);
            palette[38] = new Color(84,142,92);
            palette[39] = new Color(92,162,124);
            palette[40] = new Color(4,2,28);
            palette[41] = new Color(4,18,52);
            palette[42] = new Color(4,10,84);
            palette[43] = new Color(36,54,76);
            palette[44] = new Color(52,66,84);
            palette[45] = new Color(20,54,124);
            palette[46] = new Color(52,78,108);
            palette[47] = new Color(68,90,116);
            palette[48] = new Color(76,106,140);
            palette[49] = new Color(4,114,156);
            palette[50] = new Color(92,130,164);
            palette[51] = new Color(68,106,212);
            palette[52] = new Color(28,174,188);
            palette[53] = new Color(36,38,252);
            palette[54] = new Color(100,150,188);
            palette[55] = new Color(116,170,204);
            palette[56] = new Color(140,194,220);
            palette[57] = new Color(148,222,244);
            palette[58] = new Color(172,222,236);
            palette[59] = new Color(172,254,252);
            palette[60] = new Color(204,250,252);
            palette[61] = new Color(252,254,4);
            palette[62] = new Color(244,230,148);
            palette[63] = new Color(252,254,196);
            palette[64] = new Color(12,14,12);
            palette[65] = new Color(28,22,20);
            palette[66] = new Color(28,30,36);
            palette[67] = new Color(44,42,52);
            palette[68] = new Color(60,50,36);
            palette[69] = new Color(60,62,68);
            palette[70] = new Color(76,66,52);
            palette[71] = new Color(76,78,76);
            palette[72] = new Color(92,82,68);
            palette[73] = new Color(92,90,92);
            palette[74] = new Color(108,106,108);
            palette[75] = new Color(124,134,108);
            palette[76] = new Color(108,150,108);
            palette[77] = new Color(116,166,124);
            palette[78] = new Color(156,150,140);
            palette[79] = new Color(148,186,148);
            palette[80] = new Color(156,198,172);
            palette[81] = new Color(180,178,180);
            palette[82] = new Color(172,206,180);
            palette[83] = new Color(196,194,188);
            palette[84] = new Color(204,226,212);
            palette[85] = new Color(244,242,244);
            palette[86] = new Color(28,18,12);
            palette[87] = new Color(44,26,12);
            palette[88] = new Color(52,18,12);
            palette[89] = new Color(52,34,12);
            palette[90] = new Color(60,18,36);
            palette[91] = new Color(52,42,36);
            palette[92] = new Color(68,54,12);
            palette[93] = new Color(76,50,28);
            palette[94] = new Color(100,2,4);
            palette[95] = new Color(84,42,36);
            palette[96] = new Color(84,66,20);
            palette[97] = new Color(92,86,20);
            palette[98] = new Color(132,6,4);
            palette[99] = new Color(108,78,52);
            palette[100] = new Color(124,58,52);
            palette[101] = new Color(116,102,36);
            palette[102] = new Color(124,82,84);
            palette[103] = new Color(164,54,28);
            palette[104] = new Color(148,110,4);
            palette[105] = new Color(156,94,68);
            palette[106] = new Color(140,130,52);
            palette[107] = new Color(156,118,84);
            palette[108] = new Color(188,86,68);
            palette[109] = new Color(180,146,28);
            palette[110] = new Color(180,118,92);
            palette[111] = new Color(244,6,4);
            palette[112] = new Color(204,122,84);
            palette[113] = new Color(252,106,84);
            palette[114] = new Color(228,166,132);
            palette[115] = new Color(252,150,108);
            palette[116] = new Color(252,206,44);
            palette[117] = new Color(20,254,28);
            palette[118] = new Color(12,2,36);
            palette[119] = new Color(28,30,44);
            palette[120] = new Color(36,38,76);
            palette[121] = new Color(44,46,108);
            palette[122] = new Color(44,50,132);
            palette[123] = new Color(36,26,188);
            palette[124] = new Color(52,62,172);
            palette[125] = new Color(108,106,148);
            palette[126] = new Color(100,146,252);
            palette[127] = new Color(124,174,252);
            palette[128] = new Color(4,230,252);
            palette[129] = new Color(156,146,68);
            palette[130] = new Color(172,150,84);
            palette[131] = new Color(188,166,92);
            palette[132] = new Color(204,186,100);
            palette[133] = new Color(236,218,132);
            palette[134] = new Color(236,198,180);
            palette[135] = new Color(252,254,60);
            palette[136] = new Color(252,254,124);
            palette[137] = new Color(252,254,164);
            palette[138] = new Color(12,10,12);
            palette[139] = new Color(20,18,20);
            palette[140] = new Color(28,26,28);
            palette[141] = new Color(44,42,44);
            palette[142] = new Color(52,54,52);
            palette[143] = new Color(76,62,60);
            palette[144] = new Color(68,70,68);
            palette[145] = new Color(76,74,92);
            palette[146] = new Color(92,90,108);
            palette[147] = new Color(116,106,60);
            palette[148] = new Color(124,102,92);
            palette[149] = new Color(100,98,124);
            palette[150] = new Color(132,118,116);
            palette[151] = new Color(132,134,156);
            palette[152] = new Color(172,142,124);
            palette[153] = new Color(172,154,148);
            palette[154] = new Color(148,146,188);
            palette[155] = new Color(188,186,236);
            palette[156] = new Color(252,142,20);
            palette[157] = new Color(20,86,60);
            palette[158] = new Color(36,146,116);
            palette[159] = new Color(44,182,148);
            palette[160] = new Color(4,34,100);
            palette[161] = new Color(76,30,84);
            palette[162] = new Color(12,54,156);
            palette[163] = new Color(108,50,124);
            palette[164] = new Color(140,66,156);
            palette[165] = new Color(12,74,204);
            palette[166] = new Color(188,186,52);
            palette[167] = new Color(220,222,60);
            palette[168] = new Color(20,2,4);
            palette[169] = new Color(36,2,4);
            palette[170] = new Color(52,2,4);
            palette[171] = new Color(76,2,4);
            palette[172] = new Color(100,26,4);
            palette[173] = new Color(140,42,12);
            palette[174] = new Color(204,26,28);
            palette[175] = new Color(228,46,44);
            palette[176] = new Color(236,34,36);
            palette[177] = new Color(236,82,20);
            palette[178] = new Color(252,34,36);
            palette[179] = new Color(236,122,36);
            palette[180] = new Color(252,174,60);
            palette[181] = new Color(4,22,4);
            palette[182] = new Color(4,42,4);
            palette[183] = new Color(4,70,4);
            palette[184] = new Color(4,102,4);
            palette[185] = new Color(12,130,12);
            palette[186] = new Color(36,154,36);
            palette[187] = new Color(60,158,60);
            palette[188] = new Color(92,178,92);
            palette[189] = new Color(108,186,108);
            palette[190] = new Color(132,198,132);
            palette[191] = new Color(148,214,148);
            palette[192] = new Color(12,22,36);
            palette[193] = new Color(36,62,100);
            palette[194] = new Color(52,82,132);
            palette[195] = new Color(60,94,148);
            palette[196] = new Color(76,118,180);
            palette[197] = new Color(84,134,196);
            palette[198] = new Color(100,150,212);
            palette[199] = new Color(124,182,236);
            palette[255] = new Color(252,254,252);
        }
    }
}
