package com.mygdx.game.japanese;


import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import java.util.Hashtable;

/**
 * Created by firasAltayeb on 17/14/2117.
 */

public class LetterLvlCounter {

    public static int
         hiraganaALvl = 1,      hiraganaKaLvl = 1,
         hiraganaILvl = 1,      hiraganaKiLvl = 1,
         hiraganaULvl = 1,      hiraganaKuLvl = 1,
         hiraganaELvl = 1,      hiraganaKeLvl = 1,
         hiraganaOLvl = 1,      hiraganaKoLvl = 1,

         hiraganaSaLvl = 1,     hiraganaTaLvl = 1,
         hiraganaShiLvl = 1,    hiraganaChiLvl = 1,
         hiraganaSuLvl = 1,     hiraganaTsuLvl = 1,
         hiraganaSeLvl = 1,     hiraganaTeLvl = 1,
         hiraganaSoLvl = 1,     hiraganaToLvl = 1,

         hiraganaNaLvl = 1,     hiraganaHaLvl = 1,
         hiraganaNiLvl = 1,     hiraganaHiLvl = 1,
         hiraganaNuLvl = 1,     hiraganaHuLvl = 1,
         hiraganaNeLvl = 1,     hiraganaHeLvl = 1,
         hiraganaNoLvl = 1,     hiraganaHoLvl = 1,

         hiraganaMaLvl = 1,     hiraganaRaLvl = 1,
         hiraganaMiLvl = 1,     hiraganaRiLvl = 1,
         hiraganaMuLvl = 1,     hiraganaRuLvl = 1,
         hiraganaMeLvl = 1,     hiraganaReLvl = 1,
         hiraganaMoLvl = 1,     hiraganaRoLvl = 1,

         hiraganaNLvl  = 1,

         hiraganaGaLvl = 1,     hiraganaZaLvl = 1,
         hiraganaGiLvl = 1,     hiraganaJiLvl = 1,
         hiraganaGuLvl = 1,     hiraganaZuLvl = 1,
         hiraganaGeLvl = 1,     hiraganaZeLvl = 1,
         hiraganaGoLvl = 1,     hiraganaZoLvl = 1,

         hiraganaDaLvl = 1,     hiraganaBaLvl = 1,
         hiraganaDiLvl = 1,     hiraganaBiLvl = 1,
         hiraganaDuLvl = 1,     hiraganaBuLvl = 1,
         hiraganaDeLvl = 1,     hiraganaBeLvl = 1,
         hiraganaDoLvl = 1,     hiraganaBoLvl = 1,

         hiraganaPaLvl = 1,     hiraganaYaLvl = 1,
         hiraganaPiLvl = 1,     hiraganaYuLvl = 1,
         hiraganaPuLvl = 1,     hiraganaYoLvl = 1,
         hiraganaPeLvl = 1,     hiraganaWaLvl = 1,
         hiraganaPoLvl = 1,     hiraganaWoLvl = 1,

         hiraganaKyaLvl = 1,    hiraganaShaLvl = 1,
         hiraganaKyuLvl = 1,    hiraganaShuLvl = 1,
         hiraganaKyoLvl = 1,    hiraganaShoLvl = 1,

         hiraganaChaLvl = 1,    hiraganaHyaLvl = 1,
         hiraganaChuLvl = 1,    hiraganaHyuLvl = 1,
         hiraganaChoLvl = 1,    hiraganaHyoLvl = 1,

         hiraganaNyaLvl = 1,    hiraganaMyaLvl = 1,
         hiraganaNyuLvl = 1,    hiraganaMyuLvl = 1,
         hiraganaNyoLvl = 1,    hiraganaMyoLvl = 1,

         hiraganaRyaLvl = 1,    hiraganaGyaLvl = 1,
         hiraganaRyuLvl = 1,    hiraganaGyuLvl = 1,
         hiraganaRyoLvl = 1,    hiraganaGyoLvl = 1,

         hiraganaJyaLvl = 1,    hiraganaDyaLvl = 1,
         hiraganaJyuLvl = 1,    hiraganaDyuLvl = 1,
         hiraganaJyoLvl = 1,    hiraganaDyoLvl = 1,

         hiraganaByaLvl = 1,    hiraganaPyaLvl = 1,
         hiraganaByuLvl = 1,    hiraganaPyuLvl = 1,
         hiraganaByoLvl = 1,    hiraganaPyoLvl = 1,

         katakanaALvl = 1,      katakanaKaLvl = 1,
         katakanaILvl = 1,      katakanaKiLvl = 1,
         katakanaULvl = 1,      katakanaKuLvl = 1,
         katakanaELvl = 1,      katakanaKeLvl = 1,
         katakanaOLvl = 1,      katakanaKoLvl = 1,

         katakanaSaLvl = 1,     katakanaTaLvl = 1,
         katakanaShiLvl = 1,    katakanaChiLvl = 1,
         katakanaSuLvl = 1,     katakanaTsuLvl = 1,
         katakanaSeLvl = 1,     katakanaTeLvl = 1,
         katakanaSoLvl = 1,     katakanaToLvl = 1,

         katakanaNaLvl = 1,     katakanaHaLvl = 1,
         katakanaNiLvl = 1,     katakanaHiLvl = 1,
         katakanaNuLvl = 1,     katakanaHuLvl = 1,
         katakanaNeLvl = 1,     katakanaHeLvl = 1,
         katakanaNoLvl = 1,     katakanaHoLvl = 1,

         katakanaMaLvl = 1,     katakanaRaLvl = 1,
         katakanaMiLvl = 1,     katakanaRiLvl = 1,
         katakanaMuLvl = 1,     katakanaRuLvl = 1,
         katakanaMeLvl = 1,     katakanaReLvl = 1,
         katakanaMoLvl = 1,     katakanaRoLvl = 1,

         katakanaNLvl  = 1,

         katakanaGaLvl = 1,     katakanaZaLvl = 1,
         katakanaGiLvl = 1,     katakanaJiLvl = 1,
         katakanaGuLvl = 1,     katakanaZuLvl = 1,
         katakanaGeLvl = 1,     katakanaZeLvl = 1,
         katakanaGoLvl = 1,     katakanaZoLvl = 1,

         katakanaDaLvl = 1,     katakanaBaLvl = 1,
         katakanaDiLvl = 1,     katakanaBiLvl = 1,
         katakanaDuLvl = 1,     katakanaBuLvl = 1,
         katakanaDeLvl = 1,     katakanaBeLvl = 1,
         katakanaDoLvl = 1,     katakanaBoLvl = 1,

         katakanaPaLvl = 1,     katakanaYaLvl = 1,
         katakanaPiLvl = 1,     katakanaYuLvl = 1,
         katakanaPuLvl = 1,     katakanaYoLvl = 1,
         katakanaPeLvl = 1,     katakanaWaLvl = 1,
         katakanaPoLvl = 1,     katakanaWoLvl = 1,

         katakanaKyaLvl = 1,    katakanaShaLvl = 1,
         katakanaKyuLvl = 1,    katakanaShuLvl = 1,
         katakanaKyoLvl = 1,    katakanaShoLvl = 1,

         katakanaChaLvl = 1,    katakanaHyaLvl = 1,
         katakanaChuLvl = 1,    katakanaHyuLvl = 1,
         katakanaChoLvl = 1,    katakanaHyoLvl = 1,

         katakanaNyaLvl = 1,    katakanaMyaLvl = 1,
         katakanaNyuLvl = 1,    katakanaMyuLvl = 1,
         katakanaNyoLvl = 1,    katakanaMyoLvl = 1,

         katakanaRyaLvl = 1,    katakanaGyaLvl = 1,
         katakanaRyuLvl = 1,    katakanaGyuLvl = 1,
         katakanaRyoLvl = 1,    katakanaGyoLvl = 1,

         katakanaJyaLvl = 1,    katakanaDyaLvl = 1,
         katakanaJyuLvl = 1,    katakanaDyuLvl = 1,
         katakanaJyoLvl = 1,    katakanaDyoLvl = 1,

         katakanaByaLvl = 1,    katakanaPyaLvl = 1,
         katakanaByuLvl = 1,    katakanaPyuLvl = 1,
         katakanaByoLvl = 1,    katakanaPyoLvl = 1,

             kanjiHaLvl = 1,      kanjiHanaLvl = 1,
             kanjiKiLvl = 1,      kanjiMoriLvl = 1,
          kanjiMushiLvl = 1,      kanjiIshiLvl = 1,
           kanjiKazeLvl = 1,     kanjiTsuchiLvl = 1,
           kanjiUchiLvl = 1,      kanjiYamaLvl = 1,
            kanjiUmiLvl = 1,    kanjiSakanaLvl = 1,
           kanjiMizuLvl = 1,       kanjiKaiLvl = 1,
            kanjiIkeLvl = 1,      kanjiYukiLvl = 1,
          kanjiKooriLvl = 1,      kanjiKawaLvl = 1,
        kanjiHayashiLvl = 1,      kanjiFuyuLvl = 1,
             kanjiToLvl = 1,       kanjiMonLvl = 1,
           kanjiTeraLvl = 1,       kanjiAnaLvl = 1,
           kanjiSotoLvl = 1,        kanjiKaLvl = 1,
             kanjiHiLvl = 1,       kanjiChiLvl = 1,
            kanjiAkaLvl = 1,    kanjiHikariLvl = 1;


     private static boolean allHiraganaMemorised = false;
     private static boolean allKatakanaMemorised = false;
     private static boolean allKanjiMemorised = false;
     private static Hashtable<String, Integer> hiraganaLvlTable;
     private static Hashtable<String, Integer> katakanaLvlTable;
     private static Hashtable<String, Integer> kanjiLvlTable;
     private static Array<Integer> hiraganaList;
     private static Array<Integer> katakanaList;
     private static Array<Integer> kanjiList;

     public static Hashtable<String, Integer> getHiraganaLvlTable(){

          hiraganaLvlTable = new Hashtable<String, Integer>();

          hiraganaLvlTable.put("hiraganaA", hiraganaALvl);
          hiraganaLvlTable.put("hiraganaI", hiraganaILvl);
          hiraganaLvlTable.put("hiraganaU", hiraganaULvl);
          hiraganaLvlTable.put("hiraganaE", hiraganaELvl);
          hiraganaLvlTable.put("hiraganaO", hiraganaOLvl);
          hiraganaLvlTable.put("hiraganaKa", hiraganaKaLvl);
          hiraganaLvlTable.put("hiraganaKi", hiraganaKiLvl);
          hiraganaLvlTable.put("hiraganaKu", hiraganaKuLvl);
          hiraganaLvlTable.put("hiraganaKe", hiraganaKeLvl);
          hiraganaLvlTable.put("hiraganaKo", hiraganaKoLvl);
          hiraganaLvlTable.put("hiraganaSa", hiraganaSaLvl);
          hiraganaLvlTable.put("hiraganaShi", hiraganaShiLvl);
          hiraganaLvlTable.put("hiraganaSu", hiraganaSuLvl);
          hiraganaLvlTable.put("hiraganaSe", hiraganaSeLvl);
          hiraganaLvlTable.put("hiraganaSo", hiraganaSoLvl);
          hiraganaLvlTable.put("hiraganaTa", hiraganaTaLvl);
          hiraganaLvlTable.put("hiraganaChi", hiraganaChiLvl);
          hiraganaLvlTable.put("hiraganaTsu", hiraganaTsuLvl);
          hiraganaLvlTable.put("hiraganaTe", hiraganaTeLvl);
          hiraganaLvlTable.put("hiraganaTo", hiraganaToLvl);
          hiraganaLvlTable.put("hiraganaNa", hiraganaNaLvl);
          hiraganaLvlTable.put("hiraganaNi", hiraganaNiLvl);
          hiraganaLvlTable.put("hiraganaNu", hiraganaNuLvl);
          hiraganaLvlTable.put("hiraganaNe", hiraganaNeLvl);
          hiraganaLvlTable.put("hiraganaNo", hiraganaNoLvl);
          hiraganaLvlTable.put("hiraganaHa", hiraganaHaLvl);
          hiraganaLvlTable.put("hiraganaHi", hiraganaHiLvl);
          hiraganaLvlTable.put("hiraganaHu", hiraganaHuLvl);
          hiraganaLvlTable.put("hiraganaHe", hiraganaHeLvl);
          hiraganaLvlTable.put("hiraganaHo", hiraganaHoLvl);
          hiraganaLvlTable.put("hiraganaMa", hiraganaMaLvl);
          hiraganaLvlTable.put("hiraganaMi", hiraganaMiLvl);
          hiraganaLvlTable.put("hiraganaMu", hiraganaMuLvl);
          hiraganaLvlTable.put("hiraganaMe", hiraganaMeLvl);
          hiraganaLvlTable.put("hiraganaMo", hiraganaMoLvl);
          hiraganaLvlTable.put("hiraganaRa", hiraganaRaLvl);
          hiraganaLvlTable.put("hiraganaRi", hiraganaRiLvl);
          hiraganaLvlTable.put("hiraganaRu", hiraganaRuLvl);
          hiraganaLvlTable.put("hiraganaRe", hiraganaReLvl);
          hiraganaLvlTable.put("hiraganaRo", hiraganaRoLvl);
          hiraganaLvlTable.put("hiraganaYu", hiraganaYuLvl);
          hiraganaLvlTable.put("hiraganaYo", hiraganaYoLvl);
          hiraganaLvlTable.put("hiraganaWa", hiraganaWaLvl);
          hiraganaLvlTable.put("hiraganaWo", hiraganaWoLvl);

          hiraganaLvlTable.put("hiraganaN", hiraganaNLvl);

          hiraganaLvlTable.put("hiraganaGa", hiraganaGaLvl);
          hiraganaLvlTable.put("hiraganaGi", hiraganaGiLvl);
          hiraganaLvlTable.put("hiraganaGu", hiraganaGuLvl);
          hiraganaLvlTable.put("hiraganaGe", hiraganaGeLvl);
          hiraganaLvlTable.put("hiraganaGo", hiraganaGoLvl);
          hiraganaLvlTable.put("hiraganaZa", hiraganaZaLvl);
          hiraganaLvlTable.put("hiraganaJi", hiraganaJiLvl);
          hiraganaLvlTable.put("hiraganaZu", hiraganaZuLvl);
          hiraganaLvlTable.put("hiraganaZe", hiraganaZeLvl);
          hiraganaLvlTable.put("hiraganaZo", hiraganaZoLvl);
          hiraganaLvlTable.put("hiraganaDa", hiraganaDaLvl);
          hiraganaLvlTable.put("hiraganaDi", hiraganaDiLvl);
          hiraganaLvlTable.put("hiraganaDu", hiraganaDuLvl);
          hiraganaLvlTable.put("hiraganaDe", hiraganaDeLvl);
          hiraganaLvlTable.put("hiraganaDo", hiraganaDoLvl);
          hiraganaLvlTable.put("hiraganaBa", hiraganaBaLvl);
          hiraganaLvlTable.put("hiraganaBi", hiraganaBiLvl);
          hiraganaLvlTable.put("hiraganaBu", hiraganaBuLvl);
          hiraganaLvlTable.put("hiraganaBe", hiraganaBeLvl);
          hiraganaLvlTable.put("hiraganaBo", hiraganaBoLvl);
          hiraganaLvlTable.put("hiraganaPa", hiraganaPaLvl);
          hiraganaLvlTable.put("hiraganaPi", hiraganaPiLvl);
          hiraganaLvlTable.put("hiraganaPu", hiraganaPuLvl);
          hiraganaLvlTable.put("hiraganaPe", hiraganaPeLvl);
          hiraganaLvlTable.put("hiraganaPo", hiraganaPoLvl);
          hiraganaLvlTable.put("hiraganaYa", hiraganaYaLvl);
          hiraganaLvlTable.put("hiraganaKya", hiraganaKyaLvl);
          hiraganaLvlTable.put("hiraganaKyu", hiraganaKyuLvl);
          hiraganaLvlTable.put("hiraganaKyo", hiraganaKyoLvl);
          hiraganaLvlTable.put("hiraganaSha", hiraganaShaLvl);
          hiraganaLvlTable.put("hiraganaShu", hiraganaShuLvl);
          hiraganaLvlTable.put("hiraganaSho", hiraganaShoLvl);
          hiraganaLvlTable.put("hiraganaCha", hiraganaChaLvl);
          hiraganaLvlTable.put("hiraganaChu", hiraganaChuLvl);
          hiraganaLvlTable.put("hiraganaCho", hiraganaChoLvl);
          hiraganaLvlTable.put("hiraganaHya", hiraganaHyaLvl);
          hiraganaLvlTable.put("hiraganaHyu", hiraganaHyuLvl);
          hiraganaLvlTable.put("hiraganaHyo", hiraganaHyoLvl);
          hiraganaLvlTable.put("hiraganaNya", hiraganaNyaLvl);
          hiraganaLvlTable.put("hiraganaNyu", hiraganaNyuLvl);
          hiraganaLvlTable.put("hiraganaNyo", hiraganaNyoLvl);
          hiraganaLvlTable.put("hiraganaMya", hiraganaMyaLvl);
          hiraganaLvlTable.put("hiraganaMyu", hiraganaMyuLvl);
          hiraganaLvlTable.put("hiraganaMyo", hiraganaMyoLvl);
          hiraganaLvlTable.put("hiraganaRya", hiraganaRyaLvl);
          hiraganaLvlTable.put("hiraganaRyu", hiraganaRyuLvl);
          hiraganaLvlTable.put("hiraganaRyo", hiraganaRyoLvl);
          hiraganaLvlTable.put("hiraganaGya", hiraganaGyaLvl);
          hiraganaLvlTable.put("hiraganaGyu", hiraganaGyuLvl);
          hiraganaLvlTable.put("hiraganaGyo", hiraganaGyoLvl);
          hiraganaLvlTable.put("hiraganaJya", hiraganaJyaLvl);
          hiraganaLvlTable.put("hiraganaJyu", hiraganaJyuLvl);
          hiraganaLvlTable.put("hiraganaJyo", hiraganaJyoLvl);
          hiraganaLvlTable.put("hiraganaDya", hiraganaDyaLvl);
          hiraganaLvlTable.put("hiraganaDyu", hiraganaDyuLvl);
          hiraganaLvlTable.put("hiraganaDyo", hiraganaDyoLvl);
          hiraganaLvlTable.put("hiraganaBya", hiraganaByaLvl);
          hiraganaLvlTable.put("hiraganaByu", hiraganaByuLvl);
          hiraganaLvlTable.put("hiraganaByo", hiraganaByoLvl);
          hiraganaLvlTable.put("hiraganaPya", hiraganaPyaLvl);
          hiraganaLvlTable.put("hiraganaPyu", hiraganaPyuLvl);
          hiraganaLvlTable.put("hiraganaPyo", hiraganaPyoLvl);

          return hiraganaLvlTable;
     }

     public static Hashtable<String, Integer> getKatakanaLvlTable() {

          katakanaLvlTable = new Hashtable<String, Integer>();

          katakanaLvlTable.put("katakanaA", katakanaALvl);
          katakanaLvlTable.put("katakanaI", katakanaILvl);
          katakanaLvlTable.put("katakanaU", katakanaULvl);
          katakanaLvlTable.put("katakanaE", katakanaELvl);
          katakanaLvlTable.put("katakanaO", katakanaOLvl);
          katakanaLvlTable.put("katakanaKa", katakanaKaLvl);
          katakanaLvlTable.put("katakanaKi", katakanaKiLvl);
          katakanaLvlTable.put("katakanaKu", katakanaKuLvl);
          katakanaLvlTable.put("katakanaKe", katakanaKeLvl);
          katakanaLvlTable.put("katakanaKo", katakanaKoLvl);
          katakanaLvlTable.put("katakanaSa", katakanaSaLvl);
          katakanaLvlTable.put("katakanaShi", katakanaShiLvl);
          katakanaLvlTable.put("katakanaSu", katakanaSuLvl);
          katakanaLvlTable.put("katakanaSe", katakanaSeLvl);
          katakanaLvlTable.put("katakanaSo", katakanaSoLvl);
          katakanaLvlTable.put("katakanaTa", katakanaTaLvl);
          katakanaLvlTable.put("katakanaChi", katakanaChiLvl);
          katakanaLvlTable.put("katakanaTsu", katakanaTsuLvl);
          katakanaLvlTable.put("katakanaTe", katakanaTeLvl);
          katakanaLvlTable.put("katakanaTo", katakanaToLvl);
          katakanaLvlTable.put("katakanaNa", katakanaNaLvl);
          katakanaLvlTable.put("katakanaNi", katakanaNiLvl);
          katakanaLvlTable.put("katakanaNu", katakanaNuLvl);
          katakanaLvlTable.put("katakanaNe", katakanaNeLvl);
          katakanaLvlTable.put("katakanaNo", katakanaNoLvl);
          katakanaLvlTable.put("katakanaHa", katakanaHaLvl);
          katakanaLvlTable.put("katakanaHi", katakanaHiLvl);
          katakanaLvlTable.put("katakanaHu", katakanaHuLvl);
          katakanaLvlTable.put("katakanaHe", katakanaHeLvl);
          katakanaLvlTable.put("katakanaHo", katakanaHoLvl);
          katakanaLvlTable.put("katakanaMa", katakanaMaLvl);
          katakanaLvlTable.put("katakanaMi", katakanaMiLvl);
          katakanaLvlTable.put("katakanaMu", katakanaMuLvl);
          katakanaLvlTable.put("katakanaMe", katakanaMeLvl);
          katakanaLvlTable.put("katakanaMo", katakanaMoLvl);
          katakanaLvlTable.put("katakanaRa", katakanaRaLvl);
          katakanaLvlTable.put("katakanaRi", katakanaRiLvl);
          katakanaLvlTable.put("katakanaRu", katakanaRuLvl);
          katakanaLvlTable.put("katakanaRe", katakanaReLvl);
          katakanaLvlTable.put("katakanaRo", katakanaRoLvl);
          katakanaLvlTable.put("katakanaYu", katakanaYuLvl);
          katakanaLvlTable.put("katakanaYo", katakanaYoLvl);
          katakanaLvlTable.put("katakanaWa", katakanaWaLvl);
          katakanaLvlTable.put("katakanaWo", katakanaWoLvl);

          katakanaLvlTable.put("katakanaN", katakanaNLvl);

          katakanaLvlTable.put("katakanaGa", katakanaGaLvl);
          katakanaLvlTable.put("katakanaGi", katakanaGiLvl);
          katakanaLvlTable.put("katakanaGu", katakanaGuLvl);
          katakanaLvlTable.put("katakanaGe", katakanaGeLvl);
          katakanaLvlTable.put("katakanaGo", katakanaGoLvl);
          katakanaLvlTable.put("katakanaZa", katakanaZaLvl);
          katakanaLvlTable.put("katakanaJi", katakanaJiLvl);
          katakanaLvlTable.put("katakanaZu", katakanaZuLvl);
          katakanaLvlTable.put("katakanaZe", katakanaZeLvl);
          katakanaLvlTable.put("katakanaZo", katakanaZoLvl);
          katakanaLvlTable.put("katakanaDa", katakanaDaLvl);
          katakanaLvlTable.put("katakanaDi", katakanaDiLvl);
          katakanaLvlTable.put("katakanaDu", katakanaDuLvl);
          katakanaLvlTable.put("katakanaDe", katakanaDeLvl);
          katakanaLvlTable.put("katakanaDo", katakanaDoLvl);
          katakanaLvlTable.put("katakanaBa", katakanaBaLvl);
          katakanaLvlTable.put("katakanaBi", katakanaBiLvl);
          katakanaLvlTable.put("katakanaBu", katakanaBuLvl);
          katakanaLvlTable.put("katakanaBe", katakanaBeLvl);
          katakanaLvlTable.put("katakanaBo", katakanaBoLvl);
          katakanaLvlTable.put("katakanaPa", katakanaPaLvl);
          katakanaLvlTable.put("katakanaPi", katakanaPiLvl);
          katakanaLvlTable.put("katakanaPu", katakanaPuLvl);
          katakanaLvlTable.put("katakanaPe", katakanaPeLvl);
          katakanaLvlTable.put("katakanaPo", katakanaPoLvl);
          katakanaLvlTable.put("katakanaYa", katakanaYaLvl);
          katakanaLvlTable.put("katakanaKya", katakanaKyaLvl);
          katakanaLvlTable.put("katakanaKyu", katakanaKyuLvl);
          katakanaLvlTable.put("katakanaKyo", katakanaKyoLvl);
          katakanaLvlTable.put("katakanaSha", katakanaShaLvl);
          katakanaLvlTable.put("katakanaShu", katakanaShuLvl);
          katakanaLvlTable.put("katakanaSho", katakanaShoLvl);
          katakanaLvlTable.put("katakanaCha", katakanaChaLvl);
          katakanaLvlTable.put("katakanaChu", katakanaChuLvl);
          katakanaLvlTable.put("katakanaCho", katakanaChoLvl);
          katakanaLvlTable.put("katakanaHya", katakanaHyaLvl);
          katakanaLvlTable.put("katakanaHyu", katakanaHyuLvl);
          katakanaLvlTable.put("katakanaHyo", katakanaHyoLvl);
          katakanaLvlTable.put("katakanaNya", katakanaNyaLvl);
          katakanaLvlTable.put("katakanaNyu", katakanaNyuLvl);
          katakanaLvlTable.put("katakanaNyo", katakanaNyoLvl);
          katakanaLvlTable.put("katakanaMya", katakanaMyaLvl);
          katakanaLvlTable.put("katakanaMyu", katakanaMyuLvl);
          katakanaLvlTable.put("katakanaMyo", katakanaMyoLvl);
          katakanaLvlTable.put("katakanaRya", katakanaRyaLvl);
          katakanaLvlTable.put("katakanaRyu", katakanaRyuLvl);
          katakanaLvlTable.put("katakanaRyo", katakanaRyoLvl);
          katakanaLvlTable.put("katakanaGya", katakanaGyaLvl);
          katakanaLvlTable.put("katakanaGyu", katakanaGyuLvl);
          katakanaLvlTable.put("katakanaGyo", katakanaGyoLvl);
          katakanaLvlTable.put("katakanaJya", katakanaJyaLvl);
          katakanaLvlTable.put("katakanaJyu", katakanaJyuLvl);
          katakanaLvlTable.put("katakanaJyo", katakanaJyoLvl);
          katakanaLvlTable.put("katakanaDya", katakanaDyaLvl);
          katakanaLvlTable.put("katakanaDyu", katakanaDyuLvl);
          katakanaLvlTable.put("katakanaDyo", katakanaDyoLvl);
          katakanaLvlTable.put("katakanaBya", katakanaByaLvl);
          katakanaLvlTable.put("katakanaByu", katakanaByuLvl);
          katakanaLvlTable.put("katakanaByo", katakanaByoLvl);
          katakanaLvlTable.put("katakanaPya", katakanaPyaLvl);
          katakanaLvlTable.put("katakanaPyu", katakanaPyuLvl);
          katakanaLvlTable.put("katakanaPyo", katakanaPyoLvl);

          return katakanaLvlTable;
     }

     public static Hashtable<String, Integer> getKanjiLvlTable() {

         kanjiLvlTable = new Hashtable<String, Integer>();

         kanjiLvlTable.put("kanjiHa",       kanjiHaLvl);
         kanjiLvlTable.put("kanjiKi",       kanjiKiLvl);
         kanjiLvlTable.put("kanjiMushi",    kanjiMushiLvl);
         kanjiLvlTable.put("kanjiKaze",     kanjiKazeLvl);
         kanjiLvlTable.put("kanjiTsuchi", kanjiTsuchiLvl);
         kanjiLvlTable.put("kanjiUchi",     kanjiUchiLvl);
         kanjiLvlTable.put("kanjiUmi",      kanjiUmiLvl);
         kanjiLvlTable.put("kanjiMizu",     kanjiMizuLvl);
         kanjiLvlTable.put("kanjiIke",      kanjiIkeLvl);
         kanjiLvlTable.put("kanjiKoori",    kanjiKooriLvl);
         kanjiLvlTable.put("kanjiHayashi", kanjiHayashiLvl);
         kanjiLvlTable.put("kanjiTo",       kanjiToLvl);
         kanjiLvlTable.put("kanjiTera",     kanjiTeraLvl);
         kanjiLvlTable.put("kanjiSoto",     kanjiSotoLvl);
         kanjiLvlTable.put("kanjiHi",       kanjiHiLvl);
         kanjiLvlTable.put("kanjiAka",      kanjiAkaLvl);
         kanjiLvlTable.put("kanjiHana",     kanjiHanaLvl);
         kanjiLvlTable.put("kanjiMori",     kanjiMoriLvl);
         kanjiLvlTable.put("kanjiIshi",     kanjiIshiLvl);
         kanjiLvlTable.put("kanjiYama",     kanjiYamaLvl);
         kanjiLvlTable.put("kanjiSakana",  kanjiSakanaLvl);
         kanjiLvlTable.put("kanjiKai",      kanjiKaiLvl);
         kanjiLvlTable.put("kanjiYuki",     kanjiYukiLvl);
         kanjiLvlTable.put("kanjiKawa",     kanjiKawaLvl);
         kanjiLvlTable.put("kanjiFuyu",     kanjiFuyuLvl);
         kanjiLvlTable.put("kanjiMon",      kanjiMonLvl);
         kanjiLvlTable.put("kanjiAna",      kanjiAnaLvl);
         kanjiLvlTable.put("kanjiKa",       kanjiKaLvl);
         kanjiLvlTable.put("kanjiChi",      kanjiChiLvl);
         kanjiLvlTable.put("kanjiHikari",  kanjiHikariLvl);

          return kanjiLvlTable;
     }

     public static void increaseLvl(String letter, int addOn){
          switch (letter){
               case "hiraganaA":         hiraganaALvl = MathUtils.clamp(addOn +    hiraganaALvl, 1, 4);    break;
               case "hiraganaI":         hiraganaILvl = MathUtils.clamp(addOn +    hiraganaILvl, 1, 4);    break;
               case "hiraganaU":         hiraganaULvl = MathUtils.clamp(addOn +    hiraganaULvl, 1, 4);    break;
               case "hiraganaE":         hiraganaELvl = MathUtils.clamp(addOn +    hiraganaELvl, 1, 4);    break;
               case "hiraganaO":         hiraganaOLvl = MathUtils.clamp(addOn +    hiraganaOLvl, 1, 4);    break;
               case "hiraganaKa":       hiraganaKaLvl = MathUtils.clamp(addOn +   hiraganaKaLvl, 1, 4);    break;
               case "hiraganaKi":       hiraganaKiLvl = MathUtils.clamp(addOn +   hiraganaKiLvl, 1, 4);    break;
               case "hiraganaKu":       hiraganaKuLvl = MathUtils.clamp(addOn +   hiraganaKuLvl, 1, 4);    break;
               case "hiraganaKe":       hiraganaKeLvl = MathUtils.clamp(addOn +   hiraganaKeLvl, 1, 4);    break;
               case "hiraganaKo":       hiraganaKoLvl = MathUtils.clamp(addOn +   hiraganaKoLvl, 1, 4);    break;
               case "hiraganaSa":       hiraganaSaLvl = MathUtils.clamp(addOn +   hiraganaSaLvl, 1, 4);    break;
               case "hiraganaShi":     hiraganaShiLvl = MathUtils.clamp(addOn +  hiraganaShiLvl, 1, 4);    break;
               case "hiraganaSu":       hiraganaSuLvl = MathUtils.clamp(addOn +   hiraganaSuLvl, 1, 4);    break;
               case "hiraganaSe":       hiraganaSeLvl = MathUtils.clamp(addOn +   hiraganaSeLvl, 1, 4);    break;
               case "hiraganaSo":       hiraganaSoLvl = MathUtils.clamp(addOn +   hiraganaSoLvl, 1, 4);    break;
               case "hiraganaTa":       hiraganaTaLvl = MathUtils.clamp(addOn +   hiraganaTaLvl, 1, 4);    break;
               case "hiraganaChi":     hiraganaChiLvl = MathUtils.clamp(addOn +  hiraganaChiLvl, 1, 4);    break;
               case "hiraganaTsu":     hiraganaTsuLvl = MathUtils.clamp(addOn +  hiraganaTsuLvl, 1, 4);    break;
               case "hiraganaTe":       hiraganaTeLvl = MathUtils.clamp(addOn +   hiraganaTeLvl, 1, 4);    break;
               case "hiraganaTo":       hiraganaToLvl = MathUtils.clamp(addOn +   hiraganaToLvl, 1, 4);    break;
               case "hiraganaNa":       hiraganaNaLvl = MathUtils.clamp(addOn +   hiraganaNaLvl, 1, 4);    break;
               case "hiraganaNi":       hiraganaNiLvl = MathUtils.clamp(addOn +   hiraganaNiLvl, 1, 4);    break;
               case "hiraganaNu":       hiraganaNuLvl = MathUtils.clamp(addOn +   hiraganaNuLvl, 1, 4);    break;
               case "hiraganaNe":       hiraganaNeLvl = MathUtils.clamp(addOn +   hiraganaNeLvl, 1, 4);    break;
               case "hiraganaNo":       hiraganaNoLvl = MathUtils.clamp(addOn +   hiraganaNoLvl, 1, 4);    break;
               case "hiraganaHa":       hiraganaHaLvl = MathUtils.clamp(addOn +   hiraganaHaLvl, 1, 4);    break;
               case "hiraganaHi":       hiraganaHiLvl = MathUtils.clamp(addOn +   hiraganaHiLvl, 1, 4);    break;
               case "hiraganaHu":       hiraganaHuLvl = MathUtils.clamp(addOn +   hiraganaHuLvl, 1, 4);    break;
               case "hiraganaHe":       hiraganaHeLvl = MathUtils.clamp(addOn +   hiraganaHeLvl, 1, 4);    break;
               case "hiraganaHo":       hiraganaHoLvl = MathUtils.clamp(addOn +   hiraganaHoLvl, 1, 4);    break;
               case "hiraganaMa":       hiraganaMaLvl = MathUtils.clamp(addOn +   hiraganaMaLvl, 1, 4);    break;
               case "hiraganaMi":       hiraganaMiLvl = MathUtils.clamp(addOn +   hiraganaMiLvl, 1, 4);    break;
               case "hiraganaMu":       hiraganaMuLvl = MathUtils.clamp(addOn +   hiraganaMuLvl, 1, 4);    break;
               case "hiraganaMe":       hiraganaMeLvl = MathUtils.clamp(addOn +   hiraganaMeLvl, 1, 4);    break;
               case "hiraganaMo":       hiraganaMoLvl = MathUtils.clamp(addOn +   hiraganaMoLvl, 1, 4);    break;
               case "hiraganaRa":       hiraganaRaLvl = MathUtils.clamp(addOn +   hiraganaRaLvl, 1, 4);    break;
               case "hiraganaRi":       hiraganaRiLvl = MathUtils.clamp(addOn +   hiraganaRiLvl, 1, 4);    break;
               case "hiraganaRu":       hiraganaRuLvl = MathUtils.clamp(addOn +   hiraganaRuLvl, 1, 4);    break;
               case "hiraganaRe":       hiraganaReLvl = MathUtils.clamp(addOn +   hiraganaReLvl, 1, 4);    break;
               case "hiraganaRo":       hiraganaRoLvl = MathUtils.clamp(addOn +   hiraganaRoLvl, 1, 4);    break;
               case "hiraganaYa":       hiraganaYaLvl = MathUtils.clamp(addOn +   hiraganaYaLvl, 1, 4);    break;
               case "hiraganaYu":       hiraganaYuLvl = MathUtils.clamp(addOn +   hiraganaYuLvl, 1, 4);    break;
               case "hiraganaYo":       hiraganaYoLvl = MathUtils.clamp(addOn +   hiraganaYoLvl, 1, 4);    break;
               case "hiraganaWa":       hiraganaWaLvl = MathUtils.clamp(addOn +   hiraganaWaLvl, 1, 4);    break;
               case "hiraganaWo":       hiraganaWoLvl = MathUtils.clamp(addOn +   hiraganaWoLvl, 1, 4);    break;
               case "hiraganaN":         hiraganaNLvl = MathUtils.clamp(addOn +    hiraganaNLvl, 1, 4);    break;
               case "hiraganaGa":       hiraganaGaLvl = MathUtils.clamp(addOn +   hiraganaGaLvl, 1, 4);    break;
               case "hiraganaGi":       hiraganaGiLvl = MathUtils.clamp(addOn +   hiraganaGiLvl, 1, 4);    break;
               case "hiraganaGu":       hiraganaGuLvl = MathUtils.clamp(addOn +   hiraganaGuLvl, 1, 4);    break;
               case "hiraganaGe":       hiraganaGeLvl = MathUtils.clamp(addOn +   hiraganaGeLvl, 1, 4);    break;
               case "hiraganaGo":       hiraganaGoLvl = MathUtils.clamp(addOn +   hiraganaGoLvl, 1, 4);    break;
               case "hiraganaZa":       hiraganaZaLvl = MathUtils.clamp(addOn +   hiraganaZaLvl, 1, 4);    break;
               case "hiraganaJi":       hiraganaJiLvl = MathUtils.clamp(addOn +   hiraganaJiLvl, 1, 4);    break;
               case "hiraganaZu":       hiraganaZuLvl = MathUtils.clamp(addOn +   hiraganaZuLvl, 1, 4);    break;
               case "hiraganaZe":       hiraganaZeLvl = MathUtils.clamp(addOn +   hiraganaZeLvl, 1, 4);    break;
               case "hiraganaZo":       hiraganaZoLvl = MathUtils.clamp(addOn +   hiraganaZoLvl, 1, 4);    break;
               case "hiraganaDa":       hiraganaDaLvl = MathUtils.clamp(addOn +   hiraganaDaLvl, 1, 4);    break;
               case "hiraganaDi":       hiraganaDiLvl = MathUtils.clamp(addOn +   hiraganaDiLvl, 1, 4);    break;
               case "hiraganaDu":       hiraganaDuLvl = MathUtils.clamp(addOn +   hiraganaDuLvl, 1, 4);    break;
               case "hiraganaDe":       hiraganaDeLvl = MathUtils.clamp(addOn +   hiraganaDeLvl, 1, 4);    break;
               case "hiraganaDo":       hiraganaDoLvl = MathUtils.clamp(addOn +   hiraganaDoLvl, 1, 4);    break;
               case "hiraganaBa":       hiraganaBaLvl = MathUtils.clamp(addOn +   hiraganaBaLvl, 1, 4);    break;
               case "hiraganaBi":       hiraganaBiLvl = MathUtils.clamp(addOn +   hiraganaBiLvl, 1, 4);    break;
               case "hiraganaBu":       hiraganaBuLvl = MathUtils.clamp(addOn +   hiraganaBuLvl, 1, 4);    break;
               case "hiraganaBe":       hiraganaBeLvl = MathUtils.clamp(addOn +   hiraganaBeLvl, 1, 4);    break;
               case "hiraganaBo":       hiraganaBoLvl = MathUtils.clamp(addOn +   hiraganaBoLvl, 1, 4);    break;
               case "hiraganaPa":       hiraganaPaLvl = MathUtils.clamp(addOn +   hiraganaPaLvl, 1, 4);    break;
               case "hiraganaPi":       hiraganaPiLvl = MathUtils.clamp(addOn +   hiraganaPiLvl, 1, 4);    break;
               case "hiraganaPu":       hiraganaPuLvl = MathUtils.clamp(addOn +   hiraganaPuLvl, 1, 4);    break;
               case "hiraganaPe":       hiraganaPeLvl = MathUtils.clamp(addOn +   hiraganaPeLvl, 1, 4);    break;
               case "hiraganaPo":       hiraganaPoLvl = MathUtils.clamp(addOn +   hiraganaPoLvl, 1, 4);    break;
               case "hiraganaKya":     hiraganaKyaLvl = MathUtils.clamp(addOn +  hiraganaKyaLvl, 1, 4);    break;
               case "hiraganaKyu":     hiraganaKyuLvl = MathUtils.clamp(addOn +  hiraganaKyuLvl, 1, 4);    break;
               case "hiraganaKyo":     hiraganaKyoLvl = MathUtils.clamp(addOn +  hiraganaKyoLvl, 1, 4);    break;
               case "hiraganaSha":     hiraganaShaLvl = MathUtils.clamp(addOn +  hiraganaShaLvl, 1, 4);    break;
               case "hiraganaShu":     hiraganaShuLvl = MathUtils.clamp(addOn +  hiraganaShuLvl, 1, 4);    break;
               case "hiraganaSho":     hiraganaShoLvl = MathUtils.clamp(addOn +  hiraganaShoLvl, 1, 4);    break;
               case "hiraganaCha":     hiraganaChaLvl = MathUtils.clamp(addOn +  hiraganaChaLvl, 1, 4);    break;
               case "hiraganaChu":     hiraganaChuLvl = MathUtils.clamp(addOn +  hiraganaChuLvl, 1, 4);    break;
               case "hiraganaCho":     hiraganaChoLvl = MathUtils.clamp(addOn +  hiraganaChoLvl, 1, 4);    break;
               case "hiraganaHya":     hiraganaHyaLvl = MathUtils.clamp(addOn +  hiraganaHyaLvl, 1, 4);    break;
               case "hiraganaHyu":     hiraganaHyuLvl = MathUtils.clamp(addOn +  hiraganaHyuLvl, 1, 4);    break;
               case "hiraganaHyo":     hiraganaHyoLvl = MathUtils.clamp(addOn +  hiraganaHyoLvl, 1, 4);    break;
               case "hiraganaNya":     hiraganaNyaLvl = MathUtils.clamp(addOn +  hiraganaNyaLvl, 1, 4);    break;
               case "hiraganaNyu":     hiraganaNyuLvl = MathUtils.clamp(addOn +  hiraganaNyuLvl, 1, 4);    break;
               case "hiraganaNyo":     hiraganaNyoLvl = MathUtils.clamp(addOn +  hiraganaNyoLvl, 1, 4);    break;
               case "hiraganaMya":     hiraganaMyaLvl = MathUtils.clamp(addOn +  hiraganaMyaLvl, 1, 4);    break;
               case "hiraganaMyu":     hiraganaMyuLvl = MathUtils.clamp(addOn +  hiraganaMyuLvl, 1, 4);    break;
               case "hiraganaMyo":     hiraganaMyoLvl = MathUtils.clamp(addOn +  hiraganaMyoLvl, 1, 4);    break;
               case "hiraganaRya":     hiraganaRyaLvl = MathUtils.clamp(addOn +  hiraganaRyaLvl, 1, 4);    break;
               case "hiraganaRyu":     hiraganaRyuLvl = MathUtils.clamp(addOn +  hiraganaRyuLvl, 1, 4);    break;
               case "hiraganaRyo":     hiraganaRyoLvl = MathUtils.clamp(addOn +  hiraganaRyoLvl, 1, 4);    break;
               case "hiraganaGya":     hiraganaGyaLvl = MathUtils.clamp(addOn +  hiraganaGyaLvl, 1, 4);    break;
               case "hiraganaGyu":     hiraganaGyuLvl = MathUtils.clamp(addOn +  hiraganaGyuLvl, 1, 4);    break;
               case "hiraganaGyo":     hiraganaGyoLvl = MathUtils.clamp(addOn +  hiraganaGyoLvl, 1, 4);    break;
               case "hiraganaJya":     hiraganaJyaLvl = MathUtils.clamp(addOn +  hiraganaJyaLvl, 1, 4);    break;
               case "hiraganaJyu":     hiraganaJyuLvl = MathUtils.clamp(addOn +  hiraganaJyuLvl, 1, 4);    break;
               case "hiraganaJyo":     hiraganaJyoLvl = MathUtils.clamp(addOn +  hiraganaJyoLvl, 1, 4);    break;
               case "hiraganaDya":     hiraganaDyaLvl = MathUtils.clamp(addOn +  hiraganaDyaLvl, 1, 4);    break;
               case "hiraganaDyu":     hiraganaDyuLvl = MathUtils.clamp(addOn +  hiraganaDyuLvl, 1, 4);    break;
               case "hiraganaDyo":     hiraganaDyoLvl = MathUtils.clamp(addOn +  hiraganaDyoLvl, 1, 4);    break;
               case "hiraganaBya":     hiraganaByaLvl = MathUtils.clamp(addOn +  hiraganaByaLvl, 1, 4);    break;
               case "hiraganaByu":     hiraganaByuLvl = MathUtils.clamp(addOn +  hiraganaByuLvl, 1, 4);    break;
               case "hiraganaByo":     hiraganaByoLvl = MathUtils.clamp(addOn +  hiraganaByoLvl, 1, 4);    break;
               case "hiraganaPya":     hiraganaPyaLvl = MathUtils.clamp(addOn +  hiraganaPyaLvl, 1, 4);    break;
               case "hiraganaPyu":     hiraganaPyuLvl = MathUtils.clamp(addOn +  hiraganaPyuLvl, 1, 4);    break;
               case "hiraganaPyo":     hiraganaPyoLvl = MathUtils.clamp(addOn +  hiraganaPyoLvl, 1, 4);    break;
               case "katakanaA":         katakanaALvl = MathUtils.clamp(addOn +    katakanaALvl, 1, 4);    break;
               case "katakanaI":         katakanaILvl = MathUtils.clamp(addOn +    katakanaILvl, 1, 4);    break;
               case "katakanaU":         katakanaULvl = MathUtils.clamp(addOn +    katakanaULvl, 1, 4);    break;
               case "katakanaE":         katakanaELvl = MathUtils.clamp(addOn +    katakanaELvl, 1, 4);    break;
               case "katakanaO":         katakanaOLvl = MathUtils.clamp(addOn +    katakanaOLvl, 1, 4);    break;
               case "katakanaKa":       katakanaKaLvl = MathUtils.clamp(addOn +   katakanaKaLvl, 1, 4);    break;
               case "katakanaKi":       katakanaKiLvl = MathUtils.clamp(addOn +   katakanaKiLvl, 1, 4);    break;
               case "katakanaKu":       katakanaKuLvl = MathUtils.clamp(addOn +   katakanaKuLvl, 1, 4);    break;
               case "katakanaKe":       katakanaKeLvl = MathUtils.clamp(addOn +   katakanaKeLvl, 1, 4);    break;
               case "katakanaKo":       katakanaKoLvl = MathUtils.clamp(addOn +   katakanaKoLvl, 1, 4);    break;
               case "katakanaSa":       katakanaSaLvl = MathUtils.clamp(addOn +   katakanaSaLvl, 1, 4);    break;
               case "katakanaLvlShi":  katakanaShiLvl = MathUtils.clamp(addOn +  katakanaShiLvl, 1, 4);    break;
               case "katakanaLvlSu":   katakanaSuLvl = MathUtils.clamp(addOn +    katakanaSuLvl, 1, 4);    break;
               case "katakanaLvlSe":    katakanaSeLvl = MathUtils.clamp(addOn +   katakanaSeLvl, 1, 4);    break;
               case "katakanaLvlSo":    katakanaSoLvl = MathUtils.clamp(addOn +   katakanaSoLvl, 1, 4);    break;
               case "katakanaLvlTa":    katakanaTaLvl = MathUtils.clamp(addOn +   katakanaTaLvl, 1, 4);    break;
               case "katakanaLvlChi":  katakanaChiLvl = MathUtils.clamp(addOn +  katakanaChiLvl, 1, 4);    break;
               case "katakanaLvlTsu":  katakanaTsuLvl = MathUtils.clamp(addOn +  katakanaTsuLvl, 1, 4);    break;
               case "katakanaLvlTe":    katakanaTeLvl = MathUtils.clamp(addOn +   katakanaTeLvl, 1, 4);    break;
               case "katakanaLvlTo":    katakanaToLvl = MathUtils.clamp(addOn +   katakanaToLvl, 1, 4);    break;
               case "katakanaLvlNa":    katakanaNaLvl = MathUtils.clamp(addOn +   katakanaNaLvl, 1, 4);    break;
               case "katakanaLvlNi":    katakanaNiLvl = MathUtils.clamp(addOn +   katakanaNiLvl, 1, 4);    break;
               case "katakanaLvlNu":    katakanaNuLvl = MathUtils.clamp(addOn +   katakanaNuLvl, 1, 4);    break;
               case "katakanaLvlNe":    katakanaNeLvl = MathUtils.clamp(addOn +   katakanaNeLvl, 1, 4);    break;
               case "katakanaLvlNo":    katakanaNoLvl = MathUtils.clamp(addOn +   katakanaNoLvl, 1, 4);    break;
               case "katakanaLvlHa":    katakanaHaLvl = MathUtils.clamp(addOn +   katakanaHaLvl, 1, 4);    break;
               case "katakanaLvlHi":    katakanaHiLvl = MathUtils.clamp(addOn +   katakanaHiLvl, 1, 4);    break;
               case "katakanaLvlHu":    katakanaHuLvl = MathUtils.clamp(addOn +   katakanaHuLvl, 1, 4);    break;
               case "katakanaLvlHe":    katakanaHeLvl = MathUtils.clamp(addOn +   katakanaHeLvl, 1, 4);    break;
               case "katakanaLvlHo":    katakanaHoLvl = MathUtils.clamp(addOn +   katakanaHoLvl, 1, 4);    break;
               case "katakanaLvlMa":    katakanaMaLvl = MathUtils.clamp(addOn +   katakanaMaLvl, 1, 4);    break;
               case "katakanaLvlMi":    katakanaMiLvl = MathUtils.clamp(addOn +   katakanaMiLvl, 1, 4);    break;
               case "katakanaLvlMu":    katakanaMuLvl = MathUtils.clamp(addOn +   katakanaMuLvl, 1, 4);    break;
               case "katakanaLvlMe":    katakanaMeLvl = MathUtils.clamp(addOn +   katakanaMeLvl, 1, 4);    break;
               case "katakanaLvlMo":    katakanaMoLvl = MathUtils.clamp(addOn +   katakanaMoLvl, 1, 4);    break;
               case "katakanaLvlRa":    katakanaRaLvl = MathUtils.clamp(addOn +   katakanaRaLvl, 1, 4);    break;
               case "katakanaLvlRi":    katakanaRiLvl = MathUtils.clamp(addOn +   katakanaRiLvl, 1, 4);    break;
               case "katakanaLvlRu":    katakanaRuLvl = MathUtils.clamp(addOn +   katakanaRuLvl, 1, 4);    break;
               case "katakanaLvlRe":    katakanaReLvl = MathUtils.clamp(addOn +   katakanaReLvl, 1, 4);    break;
               case "katakanaLvlRo":    katakanaRoLvl = MathUtils.clamp(addOn +   katakanaRoLvl, 1, 4);    break;
               case "katakanaLvlYa":    katakanaYaLvl = MathUtils.clamp(addOn +   katakanaYaLvl, 1, 4);    break;
               case "katakanaLvlYu":    katakanaYuLvl = MathUtils.clamp(addOn +   katakanaYuLvl, 1, 4);    break;
               case "katakanaLvlYo":    katakanaYoLvl = MathUtils.clamp(addOn +   katakanaYoLvl, 1, 4);    break;
               case "katakanaLvlWa":    katakanaWaLvl = MathUtils.clamp(addOn +   katakanaWaLvl, 1, 4);    break;
               case "katakanaLvlWo":    katakanaWoLvl = MathUtils.clamp(addOn +   katakanaWoLvl, 1, 4);    break;
               case "katakanaLvlN":      katakanaNLvl = MathUtils.clamp(addOn +    katakanaNLvl, 1, 4);    break;
               case "katakanaLvlGa":    katakanaGaLvl = MathUtils.clamp(addOn +   katakanaGaLvl, 1, 4);    break;
               case "katakanaLvlGi":    katakanaGiLvl = MathUtils.clamp(addOn +   katakanaGiLvl, 1, 4);    break;
               case "katakanaLvlGu":    katakanaGuLvl = MathUtils.clamp(addOn +   katakanaGuLvl, 1, 4);    break;
               case "katakanaLvlGe":    katakanaGeLvl = MathUtils.clamp(addOn +   katakanaGeLvl, 1, 4);    break;
               case "katakanaLvlGo":    katakanaGoLvl = MathUtils.clamp(addOn +   katakanaGoLvl, 1, 4);    break;
               case "katakanaLvlZa":    katakanaZaLvl = MathUtils.clamp(addOn +   katakanaZaLvl, 1, 4);    break;
               case "katakanaLvlJi":    katakanaJiLvl = MathUtils.clamp(addOn +   katakanaJiLvl, 1, 4);    break;
               case "katakanaLvlZu":    katakanaZuLvl = MathUtils.clamp(addOn +   katakanaZuLvl, 1, 4);    break;
               case "katakanaLvlZe":    katakanaZeLvl = MathUtils.clamp(addOn +   katakanaZeLvl, 1, 4);    break;
               case "katakanaLvlZo":    katakanaZoLvl = MathUtils.clamp(addOn +   katakanaZoLvl, 1, 4);    break;
               case "katakanaLvlDa":    katakanaDaLvl = MathUtils.clamp(addOn +   katakanaDaLvl, 1, 4);    break;
               case "katakanaLvlDi":    katakanaDiLvl = MathUtils.clamp(addOn +   katakanaDiLvl, 1, 4);    break;
               case "katakanaLvlDu":    katakanaDuLvl = MathUtils.clamp(addOn +   katakanaDuLvl, 1, 4);    break;
               case "katakanaLvlDe":    katakanaDeLvl = MathUtils.clamp(addOn +   katakanaDeLvl, 1, 4);    break;
               case "katakanaLvlDo":    katakanaDoLvl = MathUtils.clamp(addOn +   katakanaDoLvl, 1, 4);    break;
               case "katakanaLvlBa":    katakanaBaLvl = MathUtils.clamp(addOn +   katakanaBaLvl, 1, 4);    break;
               case "katakanaLvlBi":    katakanaBiLvl = MathUtils.clamp(addOn +   katakanaBiLvl, 1, 4);    break;
               case "katakanaLvlBu":    katakanaBuLvl = MathUtils.clamp(addOn +   katakanaBuLvl, 1, 4);    break;
               case "katakanaLvlBe":    katakanaBeLvl = MathUtils.clamp(addOn +   katakanaBeLvl, 1, 4);    break;
               case "katakanaLvlBo":    katakanaBoLvl = MathUtils.clamp(addOn +   katakanaBoLvl, 1, 4);    break;
               case "katakanaLvlPa":    katakanaPaLvl = MathUtils.clamp(addOn +   katakanaPaLvl, 1, 4);    break;
               case "katakanaLvlPi":    katakanaPiLvl = MathUtils.clamp(addOn +   katakanaPiLvl, 1, 4);    break;
               case "katakanaLvlPu":    katakanaPuLvl = MathUtils.clamp(addOn +   katakanaPuLvl, 1, 4);    break;
               case "katakanaLvlPe":    katakanaPeLvl = MathUtils.clamp(addOn +   katakanaPeLvl, 1, 4);    break;
               case "katakanaLvlPo":    katakanaPoLvl = MathUtils.clamp(addOn +   katakanaPoLvl, 1, 4);    break;
               case "katakanaLvlKya":  katakanaKyaLvl = MathUtils.clamp(addOn +  katakanaKyaLvl, 1, 4);    break;
               case "katakanaLvlKyu":  katakanaKyuLvl = MathUtils.clamp(addOn +  katakanaKyuLvl, 1, 4);    break;
               case "katakanaLvlKyo":  katakanaKyoLvl = MathUtils.clamp(addOn +  katakanaKyoLvl, 1, 4);    break;
               case "katakanaLvlSha":  katakanaShaLvl = MathUtils.clamp(addOn +  katakanaShaLvl, 1, 4);    break;
               case "katakanaLvlShu":  katakanaShuLvl = MathUtils.clamp(addOn +  katakanaShuLvl, 1, 4);    break;
               case "katakanaLvlSho":  katakanaShoLvl = MathUtils.clamp(addOn +  katakanaShoLvl, 1, 4);    break;
               case "katakanaLvlCha":  katakanaChaLvl = MathUtils.clamp(addOn +  katakanaChaLvl, 1, 4);    break;
               case "katakanaLvlChu":  katakanaChuLvl = MathUtils.clamp(addOn +  katakanaChuLvl, 1, 4);    break;
               case "katakanaLvlCho":  katakanaChoLvl = MathUtils.clamp(addOn +  katakanaChoLvl, 1, 4);    break;
               case "katakanaLvlHya":  katakanaHyaLvl = MathUtils.clamp(addOn +  katakanaHyaLvl, 1, 4);    break;
               case "katakanaLvlHyu":  katakanaHyuLvl = MathUtils.clamp(addOn +  katakanaHyuLvl, 1, 4);    break;
               case "katakanaLvlHyo":  katakanaHyoLvl = MathUtils.clamp(addOn +  katakanaHyoLvl, 1, 4);    break;
               case "katakanaLvlNya":  katakanaNyaLvl = MathUtils.clamp(addOn +  katakanaNyaLvl, 1, 4);    break;
               case "katakanaLvlNyu":  katakanaNyuLvl = MathUtils.clamp(addOn +  katakanaNyuLvl, 1, 4);    break;
               case "katakanaLvlNyo":  katakanaNyoLvl = MathUtils.clamp(addOn +  katakanaNyoLvl, 1, 4);    break;
               case "katakanaLvlMya":  katakanaMyaLvl = MathUtils.clamp(addOn +  katakanaMyaLvl, 1, 4);    break;
               case "katakanaLvlMyu":  katakanaMyuLvl = MathUtils.clamp(addOn +  katakanaMyuLvl, 1, 4);    break;
               case "katakanaLvlMyo":  katakanaMyoLvl = MathUtils.clamp(addOn +  katakanaMyoLvl, 1, 4);    break;
               case "katakanaLvlRya":  katakanaRyaLvl = MathUtils.clamp(addOn +  katakanaRyaLvl, 1, 4);    break;
               case "katakanaLvlRyu":  katakanaRyuLvl = MathUtils.clamp(addOn +  katakanaRyuLvl, 1, 4);    break;
               case "katakanaLvlRyo":  katakanaRyoLvl = MathUtils.clamp(addOn +  katakanaRyoLvl, 1, 4);    break;
               case "katakanaLvlGya":  katakanaGyaLvl = MathUtils.clamp(addOn +  katakanaGyaLvl, 1, 4);    break;
               case "katakanaLvlGyu":  katakanaGyuLvl = MathUtils.clamp(addOn +  katakanaGyuLvl, 1, 4);    break;
               case "katakanaLvlGyo":  katakanaGyoLvl = MathUtils.clamp(addOn +  katakanaGyoLvl, 1, 4);    break;
               case "katakanaLvlJya":  katakanaJyaLvl = MathUtils.clamp(addOn +  katakanaJyaLvl, 1, 4);    break;
               case "katakanaLvlJyu":  katakanaJyuLvl = MathUtils.clamp(addOn +  katakanaJyuLvl, 1, 4);    break;
               case "katakanaLvlJyo":  katakanaJyoLvl = MathUtils.clamp(addOn +  katakanaJyoLvl, 1, 4);    break;
               case "katakanaLvlDya":  katakanaDyaLvl = MathUtils.clamp(addOn +  katakanaDyaLvl, 1, 4);    break;
               case "katakanaLvlDyu":  katakanaDyuLvl = MathUtils.clamp(addOn +  katakanaDyuLvl, 1, 4);    break;
               case "katakanaLvlDyo":  katakanaDyoLvl = MathUtils.clamp(addOn +  katakanaDyoLvl, 1, 4);    break;
               case "katakanaLvlBya":  katakanaByaLvl = MathUtils.clamp(addOn +  katakanaByaLvl, 1, 4);    break;
               case "katakanaLvlByu":  katakanaByuLvl = MathUtils.clamp(addOn +  katakanaByuLvl, 1, 4);    break;
               case "katakanaLvlByo":  katakanaByoLvl = MathUtils.clamp(addOn +  katakanaByoLvl, 1, 4);    break;
               case "katakanaLvlPya":  katakanaPyaLvl = MathUtils.clamp(addOn +  katakanaPyaLvl, 1, 4);    break;
               case "katakanaLvlPyu":  katakanaPyuLvl = MathUtils.clamp(addOn +  katakanaPyuLvl, 1, 4);    break;
               case "katakanaLvlPyo":  katakanaPyoLvl = MathUtils.clamp(addOn +  katakanaPyoLvl, 1, 4);    break;
               case "kanjiHa":          kanjiHaLvl = MathUtils.clamp(addOn +      kanjiHaLvl, 1, 6);    break;
               case "kanjiKi":          kanjiKiLvl = MathUtils.clamp(addOn +      kanjiKiLvl, 1, 6);    break;
               case "kanjiMushi":    kanjiMushiLvl = MathUtils.clamp(addOn +   kanjiMushiLvl, 1, 6);    break;
               case "kanjiKaze":      kanjiKazeLvl = MathUtils.clamp(addOn +    kanjiKazeLvl, 1, 6);    break;
               case "kanjiUchi":      kanjiUchiLvl = MathUtils.clamp(addOn +    kanjiUchiLvl, 1, 6);    break;
               case "kanjiUmi":        kanjiUmiLvl = MathUtils.clamp(addOn +     kanjiUmiLvl, 1, 6);    break;
               case "kanjiMizu":      kanjiMizuLvl = MathUtils.clamp(addOn +    kanjiMizuLvl, 1, 6);    break;
               case "kanjiIke":        kanjiIkeLvl = MathUtils.clamp(addOn +     kanjiIkeLvl, 1, 6);    break;
               case "kanjiKoori":    kanjiKooriLvl = MathUtils.clamp(addOn +   kanjiKooriLvl, 1, 6);    break;
               case "kanjiHayashi":kanjiHayashiLvl = MathUtils.clamp(addOn + kanjiHayashiLvl, 1, 6);    break;
               case "kanjiTo":          kanjiToLvl = MathUtils.clamp(addOn +      kanjiToLvl, 1, 6);    break;
               case "kanjiTera":      kanjiTeraLvl = MathUtils.clamp(addOn +    kanjiTeraLvl, 1, 6);    break;
               case "kanjiSoto":      kanjiSotoLvl = MathUtils.clamp(addOn +    kanjiSotoLvl, 1, 6);    break;
               case "kanjiHi":          kanjiHiLvl = MathUtils.clamp(addOn +      kanjiHiLvl, 1, 6);    break;
               case "kanjiAka":        kanjiAkaLvl = MathUtils.clamp(addOn +     kanjiAkaLvl, 1, 6);    break;
               case "kanjiHana":      kanjiHanaLvl = MathUtils.clamp(addOn +    kanjiHanaLvl, 1, 6);    break;
               case "kanjiMori":      kanjiMoriLvl = MathUtils.clamp(addOn +    kanjiMoriLvl, 1, 6);    break;
               case "kanjiIshi":      kanjiIshiLvl = MathUtils.clamp(addOn +    kanjiIshiLvl, 1, 6);    break;
               case "kanjiTsuchi":    kanjiTsuchiLvl = MathUtils.clamp(addOn + kanjiTsuchiLvl, 1, 6);    break;
               case "kanjiYama":      kanjiYamaLvl = MathUtils.clamp(addOn +    kanjiYamaLvl, 1, 6);    break;
               case "kanjiSakana":  kanjiSakanaLvl = MathUtils.clamp(addOn +  kanjiSakanaLvl, 1, 6);    break;
               case "kanjiKai":        kanjiKaiLvl = MathUtils.clamp(addOn +     kanjiKaiLvl, 1, 6);    break;
               case "kanjiYuki":      kanjiYukiLvl = MathUtils.clamp(addOn +    kanjiYukiLvl, 1, 6);    break;
               case "kanjiKawa":      kanjiKawaLvl = MathUtils.clamp(addOn +    kanjiKawaLvl, 1, 6);    break;
               case "kanjiFuyu":      kanjiFuyuLvl = MathUtils.clamp(addOn +    kanjiFuyuLvl, 1, 6);    break;
               case "kanjiMon":        kanjiMonLvl = MathUtils.clamp(addOn +     kanjiMonLvl, 1, 6);    break;
               case "kanjiAna":        kanjiAnaLvl = MathUtils.clamp(addOn +     kanjiAnaLvl, 1, 6);    break;
               case "kanjiKa":          kanjiKaLvl = MathUtils.clamp(addOn +      kanjiKaLvl, 1, 6);    break;
               case "kanjiChi":        kanjiChiLvl = MathUtils.clamp(addOn +     kanjiChiLvl, 1, 6);    break;
               case "kanjiHikari":  kanjiHikariLvl = MathUtils.clamp(addOn +  kanjiHikariLvl, 1, 6);    break;
               default: break;

          }
     }

     public static void decreaseLvl (String letter, int takeOff){
          switch (letter){
                case "hiraganaA":         hiraganaALvl = MathUtils.clamp(takeOff -    hiraganaALvl, 1, 4);    break;
                case "hiraganaI":         hiraganaILvl = MathUtils.clamp(takeOff -    hiraganaILvl, 1, 4);    break;
                case "hiraganaU":         hiraganaULvl = MathUtils.clamp(takeOff -    hiraganaULvl, 1, 4);    break;
                case "hiraganaE":         hiraganaELvl = MathUtils.clamp(takeOff -    hiraganaELvl, 1, 4);    break;
                case "hiraganaO":         hiraganaOLvl = MathUtils.clamp(takeOff -    hiraganaOLvl, 1, 4);    break;
                case "hiraganaKa":       hiraganaKaLvl = MathUtils.clamp(takeOff -   hiraganaKaLvl, 1, 4);    break;
                case "hiraganaKi":       hiraganaKiLvl = MathUtils.clamp(takeOff -   hiraganaKiLvl, 1, 4);    break;
                case "hiraganaKu":       hiraganaKuLvl = MathUtils.clamp(takeOff -   hiraganaKuLvl, 1, 4);    break;
                case "hiraganaKe":       hiraganaKeLvl = MathUtils.clamp(takeOff -   hiraganaKeLvl, 1, 4);    break;
                case "hiraganaKo":       hiraganaKoLvl = MathUtils.clamp(takeOff -   hiraganaKoLvl, 1, 4);    break;
                case "hiraganaSa":       hiraganaSaLvl = MathUtils.clamp(takeOff -   hiraganaSaLvl, 1, 4);    break;
                case "hiraganaShi":     hiraganaShiLvl = MathUtils.clamp(takeOff -  hiraganaShiLvl, 1, 4);    break;
                case "hiraganaSu":       hiraganaSuLvl = MathUtils.clamp(takeOff -   hiraganaSuLvl, 1, 4);    break;
                case "hiraganaSe":       hiraganaSeLvl = MathUtils.clamp(takeOff -   hiraganaSeLvl, 1, 4);    break;
                case "hiraganaSo":       hiraganaSoLvl = MathUtils.clamp(takeOff -   hiraganaSoLvl, 1, 4);    break;
                case "hiraganaTa":       hiraganaTaLvl = MathUtils.clamp(takeOff -   hiraganaTaLvl, 1, 4);    break;
                case "hiraganaChi":     hiraganaChiLvl = MathUtils.clamp(takeOff -  hiraganaChiLvl, 1, 4);    break;
                case "hiraganaTsu":     hiraganaTsuLvl = MathUtils.clamp(takeOff -  hiraganaTsuLvl, 1, 4);    break;
                case "hiraganaTe":       hiraganaTeLvl = MathUtils.clamp(takeOff -   hiraganaTeLvl, 1, 4);    break;
                case "hiraganaTo":       hiraganaToLvl = MathUtils.clamp(takeOff -   hiraganaToLvl, 1, 4);    break;
                case "hiraganaNa":       hiraganaNaLvl = MathUtils.clamp(takeOff -   hiraganaNaLvl, 1, 4);    break;
                case "hiraganaNi":       hiraganaNiLvl = MathUtils.clamp(takeOff -   hiraganaNiLvl, 1, 4);    break;
                case "hiraganaNu":       hiraganaNuLvl = MathUtils.clamp(takeOff -   hiraganaNuLvl, 1, 4);    break;
                case "hiraganaNe":       hiraganaNeLvl = MathUtils.clamp(takeOff -   hiraganaNeLvl, 1, 4);    break;
                case "hiraganaNo":       hiraganaNoLvl = MathUtils.clamp(takeOff -   hiraganaNoLvl, 1, 4);    break;
                case "hiraganaHa":       hiraganaHaLvl = MathUtils.clamp(takeOff -   hiraganaHaLvl, 1, 4);    break;
                case "hiraganaHi":       hiraganaHiLvl = MathUtils.clamp(takeOff -   hiraganaHiLvl, 1, 4);    break;
                case "hiraganaHu":       hiraganaHuLvl = MathUtils.clamp(takeOff -   hiraganaHuLvl, 1, 4);    break;
                case "hiraganaHe":       hiraganaHeLvl = MathUtils.clamp(takeOff -   hiraganaHeLvl, 1, 4);    break;
                case "hiraganaHo":       hiraganaHoLvl = MathUtils.clamp(takeOff -   hiraganaHoLvl, 1, 4);    break;
                case "hiraganaMa":       hiraganaMaLvl = MathUtils.clamp(takeOff -   hiraganaMaLvl, 1, 4);    break;
                case "hiraganaMi":       hiraganaMiLvl = MathUtils.clamp(takeOff -   hiraganaMiLvl, 1, 4);    break;
                case "hiraganaMu":       hiraganaMuLvl = MathUtils.clamp(takeOff -   hiraganaMuLvl, 1, 4);    break;
                case "hiraganaMe":       hiraganaMeLvl = MathUtils.clamp(takeOff -   hiraganaMeLvl, 1, 4);    break;
                case "hiraganaMo":       hiraganaMoLvl = MathUtils.clamp(takeOff -   hiraganaMoLvl, 1, 4);    break;
                case "hiraganaRa":       hiraganaRaLvl = MathUtils.clamp(takeOff -   hiraganaRaLvl, 1, 4);    break;
                case "hiraganaRi":       hiraganaRiLvl = MathUtils.clamp(takeOff -   hiraganaRiLvl, 1, 4);    break;
                case "hiraganaRu":       hiraganaRuLvl = MathUtils.clamp(takeOff -   hiraganaRuLvl, 1, 4);    break;
                case "hiraganaRe":       hiraganaReLvl = MathUtils.clamp(takeOff -   hiraganaReLvl, 1, 4);    break;
                case "hiraganaRo":       hiraganaRoLvl = MathUtils.clamp(takeOff -   hiraganaRoLvl, 1, 4);    break;
                case "hiraganaYa":       hiraganaYaLvl = MathUtils.clamp(takeOff -   hiraganaYaLvl, 1, 4);    break;
                case "hiraganaYu":       hiraganaYuLvl = MathUtils.clamp(takeOff -   hiraganaYuLvl, 1, 4);    break;
                case "hiraganaYo":       hiraganaYoLvl = MathUtils.clamp(takeOff -   hiraganaYoLvl, 1, 4);    break;
                case "hiraganaWa":       hiraganaWaLvl = MathUtils.clamp(takeOff -   hiraganaWaLvl, 1, 4);    break;
                case "hiraganaWo":       hiraganaWoLvl = MathUtils.clamp(takeOff -   hiraganaWoLvl, 1, 4);    break;
                case "hiraganaN":         hiraganaNLvl = MathUtils.clamp(takeOff -    hiraganaNLvl, 1, 4);    break;
                case "hiraganaGa":       hiraganaGaLvl = MathUtils.clamp(takeOff -   hiraganaGaLvl, 1, 4);    break;
                case "hiraganaGi":       hiraganaGiLvl = MathUtils.clamp(takeOff -   hiraganaGiLvl, 1, 4);    break;
                case "hiraganaGu":       hiraganaGuLvl = MathUtils.clamp(takeOff -   hiraganaGuLvl, 1, 4);    break;
                case "hiraganaGe":       hiraganaGeLvl = MathUtils.clamp(takeOff -   hiraganaGeLvl, 1, 4);    break;
                case "hiraganaGo":       hiraganaGoLvl = MathUtils.clamp(takeOff -   hiraganaGoLvl, 1, 4);    break;
                case "hiraganaZa":       hiraganaZaLvl = MathUtils.clamp(takeOff -   hiraganaZaLvl, 1, 4);    break;
                case "hiraganaJi":       hiraganaJiLvl = MathUtils.clamp(takeOff -   hiraganaJiLvl, 1, 4);    break;
                case "hiraganaZu":       hiraganaZuLvl = MathUtils.clamp(takeOff -   hiraganaZuLvl, 1, 4);    break;
                case "hiraganaZe":       hiraganaZeLvl = MathUtils.clamp(takeOff -   hiraganaZeLvl, 1, 4);    break;
                case "hiraganaZo":       hiraganaZoLvl = MathUtils.clamp(takeOff -   hiraganaZoLvl, 1, 4);    break;
                case "hiraganaDa":       hiraganaDaLvl = MathUtils.clamp(takeOff -   hiraganaDaLvl, 1, 4);    break;
                case "hiraganaDi":       hiraganaDiLvl = MathUtils.clamp(takeOff -   hiraganaDiLvl, 1, 4);    break;
                case "hiraganaDu":       hiraganaDuLvl = MathUtils.clamp(takeOff -   hiraganaDuLvl, 1, 4);    break;
                case "hiraganaDe":       hiraganaDeLvl = MathUtils.clamp(takeOff -   hiraganaDeLvl, 1, 4);    break;
                case "hiraganaDo":       hiraganaDoLvl = MathUtils.clamp(takeOff -   hiraganaDoLvl, 1, 4);    break;
                case "hiraganaBa":       hiraganaBaLvl = MathUtils.clamp(takeOff -   hiraganaBaLvl, 1, 4);    break;
                case "hiraganaBi":       hiraganaBiLvl = MathUtils.clamp(takeOff -   hiraganaBiLvl, 1, 4);    break;
                case "hiraganaBu":       hiraganaBuLvl = MathUtils.clamp(takeOff -   hiraganaBuLvl, 1, 4);    break;
                case "hiraganaBe":       hiraganaBeLvl = MathUtils.clamp(takeOff -   hiraganaBeLvl, 1, 4);    break;
                case "hiraganaBo":       hiraganaBoLvl = MathUtils.clamp(takeOff -   hiraganaBoLvl, 1, 4);    break;
                case "hiraganaPa":       hiraganaPaLvl = MathUtils.clamp(takeOff -   hiraganaPaLvl, 1, 4);    break;
                case "hiraganaPi":       hiraganaPiLvl = MathUtils.clamp(takeOff -   hiraganaPiLvl, 1, 4);    break;
                case "hiraganaPu":       hiraganaPuLvl = MathUtils.clamp(takeOff -   hiraganaPuLvl, 1, 4);    break;
                case "hiraganaPe":       hiraganaPeLvl = MathUtils.clamp(takeOff -   hiraganaPeLvl, 1, 4);    break;
                case "hiraganaPo":       hiraganaPoLvl = MathUtils.clamp(takeOff -   hiraganaPoLvl, 1, 4);    break;
                case "hiraganaKya":     hiraganaKyaLvl = MathUtils.clamp(takeOff -  hiraganaKyaLvl, 1, 4);    break;
                case "hiraganaKyu":     hiraganaKyuLvl = MathUtils.clamp(takeOff -  hiraganaKyuLvl, 1, 4);    break;
                case "hiraganaKyo":     hiraganaKyoLvl = MathUtils.clamp(takeOff -  hiraganaKyoLvl, 1, 4);    break;
                case "hiraganaSha":     hiraganaShaLvl = MathUtils.clamp(takeOff -  hiraganaShaLvl, 1, 4);    break;
                case "hiraganaShu":     hiraganaShuLvl = MathUtils.clamp(takeOff -  hiraganaShuLvl, 1, 4);    break;
                case "hiraganaSho":     hiraganaShoLvl = MathUtils.clamp(takeOff -  hiraganaShoLvl, 1, 4);    break;
                case "hiraganaCha":     hiraganaChaLvl = MathUtils.clamp(takeOff -  hiraganaChaLvl, 1, 4);    break;
                case "hiraganaChu":     hiraganaChuLvl = MathUtils.clamp(takeOff -  hiraganaChuLvl, 1, 4);    break;
                case "hiraganaCho":     hiraganaChoLvl = MathUtils.clamp(takeOff -  hiraganaChoLvl, 1, 4);    break;
                case "hiraganaHya":     hiraganaHyaLvl = MathUtils.clamp(takeOff -  hiraganaHyaLvl, 1, 4);    break;
                case "hiraganaHyu":     hiraganaHyuLvl = MathUtils.clamp(takeOff -  hiraganaHyuLvl, 1, 4);    break;
                case "hiraganaHyo":     hiraganaHyoLvl = MathUtils.clamp(takeOff -  hiraganaHyoLvl, 1, 4);    break;
                case "hiraganaNya":     hiraganaNyaLvl = MathUtils.clamp(takeOff -  hiraganaNyaLvl, 1, 4);    break;
                case "hiraganaNyu":     hiraganaNyuLvl = MathUtils.clamp(takeOff -  hiraganaNyuLvl, 1, 4);    break;
                case "hiraganaNyo":     hiraganaNyoLvl = MathUtils.clamp(takeOff -  hiraganaNyoLvl, 1, 4);    break;
                case "hiraganaMya":     hiraganaMyaLvl = MathUtils.clamp(takeOff -  hiraganaMyaLvl, 1, 4);    break;
                case "hiraganaMyu":     hiraganaMyuLvl = MathUtils.clamp(takeOff -  hiraganaMyuLvl, 1, 4);    break;
                case "hiraganaMyo":     hiraganaMyoLvl = MathUtils.clamp(takeOff -  hiraganaMyoLvl, 1, 4);    break;
                case "hiraganaRya":     hiraganaRyaLvl = MathUtils.clamp(takeOff -  hiraganaRyaLvl, 1, 4);    break;
                case "hiraganaRyu":     hiraganaRyuLvl = MathUtils.clamp(takeOff -  hiraganaRyuLvl, 1, 4);    break;
                case "hiraganaRyo":     hiraganaRyoLvl = MathUtils.clamp(takeOff -  hiraganaRyoLvl, 1, 4);    break;
                case "hiraganaGya":     hiraganaGyaLvl = MathUtils.clamp(takeOff -  hiraganaGyaLvl, 1, 4);    break;
                case "hiraganaGyu":     hiraganaGyuLvl = MathUtils.clamp(takeOff -  hiraganaGyuLvl, 1, 4);    break;
                case "hiraganaGyo":     hiraganaGyoLvl = MathUtils.clamp(takeOff -  hiraganaGyoLvl, 1, 4);    break;
                case "hiraganaJya":     hiraganaJyaLvl = MathUtils.clamp(takeOff -  hiraganaJyaLvl, 1, 4);    break;
                case "hiraganaJyu":     hiraganaJyuLvl = MathUtils.clamp(takeOff -  hiraganaJyuLvl, 1, 4);    break;
                case "hiraganaJyo":     hiraganaJyoLvl = MathUtils.clamp(takeOff -  hiraganaJyoLvl, 1, 4);    break;
                case "hiraganaDya":     hiraganaDyaLvl = MathUtils.clamp(takeOff -  hiraganaDyaLvl, 1, 4);    break;
                case "hiraganaDyu":     hiraganaDyuLvl = MathUtils.clamp(takeOff -  hiraganaDyuLvl, 1, 4);    break;
                case "hiraganaDyo":     hiraganaDyoLvl = MathUtils.clamp(takeOff -  hiraganaDyoLvl, 1, 4);    break;
                case "hiraganaBya":     hiraganaByaLvl = MathUtils.clamp(takeOff -  hiraganaByaLvl, 1, 4);    break;
                case "hiraganaByu":     hiraganaByuLvl = MathUtils.clamp(takeOff -  hiraganaByuLvl, 1, 4);    break;
                case "hiraganaByo":     hiraganaByoLvl = MathUtils.clamp(takeOff -  hiraganaByoLvl, 1, 4);    break;
                case "hiraganaPya":     hiraganaPyaLvl = MathUtils.clamp(takeOff -  hiraganaPyaLvl, 1, 4);    break;
                case "hiraganaPyu":     hiraganaPyuLvl = MathUtils.clamp(takeOff -  hiraganaPyuLvl, 1, 4);    break;
                case "hiraganaPyo":     hiraganaPyoLvl = MathUtils.clamp(takeOff -  hiraganaPyoLvl, 1, 4);    break;
                case "katakanaA":         katakanaALvl = MathUtils.clamp(takeOff -    katakanaALvl, 1, 4);    break;
                case "katakanaI":         katakanaILvl = MathUtils.clamp(takeOff -    katakanaILvl, 1, 4);    break;
                case "katakanaU":         katakanaULvl = MathUtils.clamp(takeOff -    katakanaULvl, 1, 4);    break;
                case "katakanaE":         katakanaELvl = MathUtils.clamp(takeOff -    katakanaELvl, 1, 4);    break;
                case "katakanaO":         katakanaOLvl = MathUtils.clamp(takeOff -    katakanaOLvl, 1, 4);    break;
                case "katakanaKa":       katakanaKaLvl = MathUtils.clamp(takeOff -   katakanaKaLvl, 1, 4);    break;
                case "katakanaKi":       katakanaKiLvl = MathUtils.clamp(takeOff -   katakanaKiLvl, 1, 4);    break;
                case "katakanaKu":       katakanaKuLvl = MathUtils.clamp(takeOff -   katakanaKuLvl, 1, 4);    break;
                case "katakanaKe":       katakanaKeLvl = MathUtils.clamp(takeOff -   katakanaKeLvl, 1, 4);    break;
                case "katakanaKo":       katakanaKoLvl = MathUtils.clamp(takeOff -   katakanaKoLvl, 1, 4);    break;
                case "katakanaSa":       katakanaSaLvl = MathUtils.clamp(takeOff -   katakanaSaLvl, 1, 4);    break;
                case "katakanaLvlShi":  katakanaShiLvl = MathUtils.clamp(takeOff -  katakanaShiLvl, 1, 4);    break;
                case "katakanaLvlSu":   katakanaSuLvl = MathUtils.clamp(takeOff -    katakanaSuLvl, 1, 4);    break;
                case "katakanaLvlSe":    katakanaSeLvl = MathUtils.clamp(takeOff -   katakanaSeLvl, 1, 4);    break;
                case "katakanaLvlSo":    katakanaSoLvl = MathUtils.clamp(takeOff -   katakanaSoLvl, 1, 4);    break;
                case "katakanaLvlTa":    katakanaTaLvl = MathUtils.clamp(takeOff -   katakanaTaLvl, 1, 4);    break;
                case "katakanaLvlChi":  katakanaChiLvl = MathUtils.clamp(takeOff -  katakanaChiLvl, 1, 4);    break;
                case "katakanaLvlTsu":  katakanaTsuLvl = MathUtils.clamp(takeOff -  katakanaTsuLvl, 1, 4);    break;
                case "katakanaLvlTe":    katakanaTeLvl = MathUtils.clamp(takeOff -   katakanaTeLvl, 1, 4);    break;
                case "katakanaLvlTo":    katakanaToLvl = MathUtils.clamp(takeOff -   katakanaToLvl, 1, 4);    break;
                case "katakanaLvlNa":    katakanaNaLvl = MathUtils.clamp(takeOff -   katakanaNaLvl, 1, 4);    break;
                case "katakanaLvlNi":    katakanaNiLvl = MathUtils.clamp(takeOff -   katakanaNiLvl, 1, 4);    break;
                case "katakanaLvlNu":    katakanaNuLvl = MathUtils.clamp(takeOff -   katakanaNuLvl, 1, 4);    break;
                case "katakanaLvlNe":    katakanaNeLvl = MathUtils.clamp(takeOff -   katakanaNeLvl, 1, 4);    break;
                case "katakanaLvlNo":    katakanaNoLvl = MathUtils.clamp(takeOff -   katakanaNoLvl, 1, 4);    break;
                case "katakanaLvlHa":    katakanaHaLvl = MathUtils.clamp(takeOff -   katakanaHaLvl, 1, 4);    break;
                case "katakanaLvlHi":    katakanaHiLvl = MathUtils.clamp(takeOff -   katakanaHiLvl, 1, 4);    break;
                case "katakanaLvlHu":    katakanaHuLvl = MathUtils.clamp(takeOff -   katakanaHuLvl, 1, 4);    break;
                case "katakanaLvlHe":    katakanaHeLvl = MathUtils.clamp(takeOff -   katakanaHeLvl, 1, 4);    break;
                case "katakanaLvlHo":    katakanaHoLvl = MathUtils.clamp(takeOff -   katakanaHoLvl, 1, 4);    break;
                case "katakanaLvlMa":    katakanaMaLvl = MathUtils.clamp(takeOff -   katakanaMaLvl, 1, 4);    break;
                case "katakanaLvlMi":    katakanaMiLvl = MathUtils.clamp(takeOff -   katakanaMiLvl, 1, 4);    break;
                case "katakanaLvlMu":    katakanaMuLvl = MathUtils.clamp(takeOff -   katakanaMuLvl, 1, 4);    break;
                case "katakanaLvlMe":    katakanaMeLvl = MathUtils.clamp(takeOff -   katakanaMeLvl, 1, 4);    break;
                case "katakanaLvlMo":    katakanaMoLvl = MathUtils.clamp(takeOff -   katakanaMoLvl, 1, 4);    break;
                case "katakanaLvlRa":    katakanaRaLvl = MathUtils.clamp(takeOff -   katakanaRaLvl, 1, 4);    break;
                case "katakanaLvlRi":    katakanaRiLvl = MathUtils.clamp(takeOff -   katakanaRiLvl, 1, 4);    break;
                case "katakanaLvlRu":    katakanaRuLvl = MathUtils.clamp(takeOff -   katakanaRuLvl, 1, 4);    break;
                case "katakanaLvlRe":    katakanaReLvl = MathUtils.clamp(takeOff -   katakanaReLvl, 1, 4);    break;
                case "katakanaLvlRo":    katakanaRoLvl = MathUtils.clamp(takeOff -   katakanaRoLvl, 1, 4);    break;
                case "katakanaLvlYa":    katakanaYaLvl = MathUtils.clamp(takeOff -   katakanaYaLvl, 1, 4);    break;
                case "katakanaLvlYu":    katakanaYuLvl = MathUtils.clamp(takeOff -   katakanaYuLvl, 1, 4);    break;
                case "katakanaLvlYo":    katakanaYoLvl = MathUtils.clamp(takeOff -   katakanaYoLvl, 1, 4);    break;
                case "katakanaLvlWa":    katakanaWaLvl = MathUtils.clamp(takeOff -   katakanaWaLvl, 1, 4);    break;
                case "katakanaLvlWo":    katakanaWoLvl = MathUtils.clamp(takeOff -   katakanaWoLvl, 1, 4);    break;
                case "katakanaLvlN":      katakanaNLvl = MathUtils.clamp(takeOff -    katakanaNLvl, 1, 4);    break;
                case "katakanaLvlGa":    katakanaGaLvl = MathUtils.clamp(takeOff -   katakanaGaLvl, 1, 4);    break;
                case "katakanaLvlGi":    katakanaGiLvl = MathUtils.clamp(takeOff -   katakanaGiLvl, 1, 4);    break;
                case "katakanaLvlGu":    katakanaGuLvl = MathUtils.clamp(takeOff -   katakanaGuLvl, 1, 4);    break;
                case "katakanaLvlGe":    katakanaGeLvl = MathUtils.clamp(takeOff -   katakanaGeLvl, 1, 4);    break;
                case "katakanaLvlGo":    katakanaGoLvl = MathUtils.clamp(takeOff -   katakanaGoLvl, 1, 4);    break;
                case "katakanaLvlZa":    katakanaZaLvl = MathUtils.clamp(takeOff -   katakanaZaLvl, 1, 4);    break;
                case "katakanaLvlJi":    katakanaJiLvl = MathUtils.clamp(takeOff -   katakanaJiLvl, 1, 4);    break;
                case "katakanaLvlZu":    katakanaZuLvl = MathUtils.clamp(takeOff -   katakanaZuLvl, 1, 4);    break;
                case "katakanaLvlZe":    katakanaZeLvl = MathUtils.clamp(takeOff -   katakanaZeLvl, 1, 4);    break;
                case "katakanaLvlZo":    katakanaZoLvl = MathUtils.clamp(takeOff -   katakanaZoLvl, 1, 4);    break;
                case "katakanaLvlDa":    katakanaDaLvl = MathUtils.clamp(takeOff -   katakanaDaLvl, 1, 4);    break;
                case "katakanaLvlDi":    katakanaDiLvl = MathUtils.clamp(takeOff -   katakanaDiLvl, 1, 4);    break;
                case "katakanaLvlDu":    katakanaDuLvl = MathUtils.clamp(takeOff -   katakanaDuLvl, 1, 4);    break;
                case "katakanaLvlDe":    katakanaDeLvl = MathUtils.clamp(takeOff -   katakanaDeLvl, 1, 4);    break;
                case "katakanaLvlDo":    katakanaDoLvl = MathUtils.clamp(takeOff -   katakanaDoLvl, 1, 4);    break;
                case "katakanaLvlBa":    katakanaBaLvl = MathUtils.clamp(takeOff -   katakanaBaLvl, 1, 4);    break;
                case "katakanaLvlBi":    katakanaBiLvl = MathUtils.clamp(takeOff -   katakanaBiLvl, 1, 4);    break;
                case "katakanaLvlBu":    katakanaBuLvl = MathUtils.clamp(takeOff -   katakanaBuLvl, 1, 4);    break;
                case "katakanaLvlBe":    katakanaBeLvl = MathUtils.clamp(takeOff -   katakanaBeLvl, 1, 4);    break;
                case "katakanaLvlBo":    katakanaBoLvl = MathUtils.clamp(takeOff -   katakanaBoLvl, 1, 4);    break;
                case "katakanaLvlPa":    katakanaPaLvl = MathUtils.clamp(takeOff -   katakanaPaLvl, 1, 4);    break;
                case "katakanaLvlPi":    katakanaPiLvl = MathUtils.clamp(takeOff -   katakanaPiLvl, 1, 4);    break;
                case "katakanaLvlPu":    katakanaPuLvl = MathUtils.clamp(takeOff -   katakanaPuLvl, 1, 4);    break;
                case "katakanaLvlPe":    katakanaPeLvl = MathUtils.clamp(takeOff -   katakanaPeLvl, 1, 4);    break;
                case "katakanaLvlPo":    katakanaPoLvl = MathUtils.clamp(takeOff -   katakanaPoLvl, 1, 4);    break;
                case "katakanaLvlKya":  katakanaKyaLvl = MathUtils.clamp(takeOff -  katakanaKyaLvl, 1, 4);    break;
                case "katakanaLvlKyu":  katakanaKyuLvl = MathUtils.clamp(takeOff -  katakanaKyuLvl, 1, 4);    break;
                case "katakanaLvlKyo":  katakanaKyoLvl = MathUtils.clamp(takeOff -  katakanaKyoLvl, 1, 4);    break;
                case "katakanaLvlSha":  katakanaShaLvl = MathUtils.clamp(takeOff -  katakanaShaLvl, 1, 4);    break;
                case "katakanaLvlShu":  katakanaShuLvl = MathUtils.clamp(takeOff -  katakanaShuLvl, 1, 4);    break;
                case "katakanaLvlSho":  katakanaShoLvl = MathUtils.clamp(takeOff -  katakanaShoLvl, 1, 4);    break;
                case "katakanaLvlCha":  katakanaChaLvl = MathUtils.clamp(takeOff -  katakanaChaLvl, 1, 4);    break;
                case "katakanaLvlChu":  katakanaChuLvl = MathUtils.clamp(takeOff -  katakanaChuLvl, 1, 4);    break;
                case "katakanaLvlCho":  katakanaChoLvl = MathUtils.clamp(takeOff -  katakanaChoLvl, 1, 4);    break;
                case "katakanaLvlHya":  katakanaHyaLvl = MathUtils.clamp(takeOff -  katakanaHyaLvl, 1, 4);    break;
                case "katakanaLvlHyu":  katakanaHyuLvl = MathUtils.clamp(takeOff -  katakanaHyuLvl, 1, 4);    break;
                case "katakanaLvlHyo":  katakanaHyoLvl = MathUtils.clamp(takeOff -  katakanaHyoLvl, 1, 4);    break;
                case "katakanaLvlNya":  katakanaNyaLvl = MathUtils.clamp(takeOff -  katakanaNyaLvl, 1, 4);    break;
                case "katakanaLvlNyu":  katakanaNyuLvl = MathUtils.clamp(takeOff -  katakanaNyuLvl, 1, 4);    break;
                case "katakanaLvlNyo":  katakanaNyoLvl = MathUtils.clamp(takeOff -  katakanaNyoLvl, 1, 4);    break;
                case "katakanaLvlMya":  katakanaMyaLvl = MathUtils.clamp(takeOff -  katakanaMyaLvl, 1, 4);    break;
                case "katakanaLvlMyu":  katakanaMyuLvl = MathUtils.clamp(takeOff -  katakanaMyuLvl, 1, 4);    break;
                case "katakanaLvlMyo":  katakanaMyoLvl = MathUtils.clamp(takeOff -  katakanaMyoLvl, 1, 4);    break;
                case "katakanaLvlRya":  katakanaRyaLvl = MathUtils.clamp(takeOff -  katakanaRyaLvl, 1, 4);    break;
                case "katakanaLvlRyu":  katakanaRyuLvl = MathUtils.clamp(takeOff -  katakanaRyuLvl, 1, 4);    break;
                case "katakanaLvlRyo":  katakanaRyoLvl = MathUtils.clamp(takeOff -  katakanaRyoLvl, 1, 4);    break;
                case "katakanaLvlGya":  katakanaGyaLvl = MathUtils.clamp(takeOff -  katakanaGyaLvl, 1, 4);    break;
                case "katakanaLvlGyu":  katakanaGyuLvl = MathUtils.clamp(takeOff -  katakanaGyuLvl, 1, 4);    break;
                case "katakanaLvlGyo":  katakanaGyoLvl = MathUtils.clamp(takeOff -  katakanaGyoLvl, 1, 4);    break;
                case "katakanaLvlJya":  katakanaJyaLvl = MathUtils.clamp(takeOff -  katakanaJyaLvl, 1, 4);    break;
                case "katakanaLvlJyu":  katakanaJyuLvl = MathUtils.clamp(takeOff -  katakanaJyuLvl, 1, 4);    break;
                case "katakanaLvlJyo":  katakanaJyoLvl = MathUtils.clamp(takeOff -  katakanaJyoLvl, 1, 4);    break;
                case "katakanaLvlDya":  katakanaDyaLvl = MathUtils.clamp(takeOff -  katakanaDyaLvl, 1, 4);    break;
                case "katakanaLvlDyu":  katakanaDyuLvl = MathUtils.clamp(takeOff -  katakanaDyuLvl, 1, 4);    break;
                case "katakanaLvlDyo":  katakanaDyoLvl = MathUtils.clamp(takeOff -  katakanaDyoLvl, 1, 4);    break;
                case "katakanaLvlBya":  katakanaByaLvl = MathUtils.clamp(takeOff -  katakanaByaLvl, 1, 4);    break;
                case "katakanaLvlByu":  katakanaByuLvl = MathUtils.clamp(takeOff -  katakanaByuLvl, 1, 4);    break;
                case "katakanaLvlByo":  katakanaByoLvl = MathUtils.clamp(takeOff -  katakanaByoLvl, 1, 4);    break;
                case "katakanaLvlPya":  katakanaPyaLvl = MathUtils.clamp(takeOff -  katakanaPyaLvl, 1, 4);    break;
                case "katakanaLvlPyu":  katakanaPyuLvl = MathUtils.clamp(takeOff -  katakanaPyuLvl, 1, 4);    break;
                case "katakanaLvlPyo":  katakanaPyoLvl = MathUtils.clamp(takeOff -  katakanaPyoLvl, 1, 4);    break;
                case "kanjiHa":          kanjiHaLvl = MathUtils.clamp(takeOff -      kanjiHaLvl, 1, 6);    break;
                case "kanjiKi":          kanjiKiLvl = MathUtils.clamp(takeOff -      kanjiKiLvl, 1, 6);    break;
                case "kanjiMushi":    kanjiMushiLvl = MathUtils.clamp(takeOff -   kanjiMushiLvl, 1, 6);    break;
                case "kanjiKaze":      kanjiKazeLvl = MathUtils.clamp(takeOff -    kanjiKazeLvl, 1, 6);    break;
                case "kanjiUchi":      kanjiUchiLvl = MathUtils.clamp(takeOff -    kanjiUchiLvl, 1, 6);    break;
                case "kanjiUmi":        kanjiUmiLvl = MathUtils.clamp(takeOff -     kanjiUmiLvl, 1, 6);    break;
                case "kanjiMizu":      kanjiMizuLvl = MathUtils.clamp(takeOff -    kanjiMizuLvl, 1, 6);    break;
                case "kanjiIke":        kanjiIkeLvl = MathUtils.clamp(takeOff -     kanjiIkeLvl, 1, 6);    break;
                case "kanjiKoori":    kanjiKooriLvl = MathUtils.clamp(takeOff -   kanjiKooriLvl, 1, 6);    break;
                case "kanjiHayashi":kanjiHayashiLvl = MathUtils.clamp(takeOff - kanjiHayashiLvl, 1, 6);    break;
                case "kanjiTo":          kanjiToLvl = MathUtils.clamp(takeOff -      kanjiToLvl, 1, 6);    break;
                case "kanjiTera":      kanjiTeraLvl = MathUtils.clamp(takeOff -    kanjiTeraLvl, 1, 6);    break;
                case "kanjiSoto":      kanjiSotoLvl = MathUtils.clamp(takeOff -    kanjiSotoLvl, 1, 6);    break;
                case "kanjiHi":          kanjiHiLvl = MathUtils.clamp(takeOff -      kanjiHiLvl, 1, 6);    break;
                case "kanjiAka":        kanjiAkaLvl = MathUtils.clamp(takeOff -     kanjiAkaLvl, 1, 6);    break;
                case "kanjiHana":      kanjiHanaLvl = MathUtils.clamp(takeOff -    kanjiHanaLvl, 1, 6);    break;
                case "kanjiMori":      kanjiMoriLvl = MathUtils.clamp(takeOff -    kanjiMoriLvl, 1, 6);    break;
                case "kanjiIshi":      kanjiIshiLvl = MathUtils.clamp(takeOff -    kanjiIshiLvl, 1, 6);    break;
                case "kanjiTsuchi":    kanjiTsuchiLvl = MathUtils.clamp(takeOff - kanjiTsuchiLvl, 1, 6);    break;
                case "kanjiYama":      kanjiYamaLvl = MathUtils.clamp(takeOff -    kanjiYamaLvl, 1, 6);    break;
                case "kanjiSakana":  kanjiSakanaLvl = MathUtils.clamp(takeOff -  kanjiSakanaLvl, 1, 6);    break;
                case "kanjiKai":        kanjiKaiLvl = MathUtils.clamp(takeOff -     kanjiKaiLvl, 1, 6);    break;
                case "kanjiYuki":      kanjiYukiLvl = MathUtils.clamp(takeOff -    kanjiYukiLvl, 1, 6);    break;
                case "kanjiKawa":      kanjiKawaLvl = MathUtils.clamp(takeOff -    kanjiKawaLvl, 1, 6);    break;
                case "kanjiFuyu":      kanjiFuyuLvl = MathUtils.clamp(takeOff -    kanjiFuyuLvl, 1, 6);    break;
                case "kanjiMon":        kanjiMonLvl = MathUtils.clamp(takeOff -     kanjiMonLvl, 1, 6);    break;
                case "kanjiAna":        kanjiAnaLvl = MathUtils.clamp(takeOff -     kanjiAnaLvl, 1, 6);    break;
                case "kanjiKa":          kanjiKaLvl = MathUtils.clamp(takeOff -      kanjiKaLvl, 1, 6);    break;
                case "kanjiChi":        kanjiChiLvl = MathUtils.clamp(takeOff -     kanjiChiLvl, 1, 6);    break;
                case "kanjiHikari":  kanjiHikariLvl = MathUtils.clamp(takeOff -  kanjiHikariLvl, 1, 6);    break;
                default: break;

          }
     }


     public static void setAllHiraganaMemorised(boolean temp){
          allHiraganaMemorised = temp;
     }

     public static void setAllKatakanaMemorised(boolean temp) {
          allKatakanaMemorised = temp;
     }

     public static void setAllKanjiMemorised(boolean temp){
          allKanjiMemorised = temp;
     }

     public static boolean isAllHiraganaMemorised() {
          return allHiraganaMemorised;
     }

     public static boolean isAllKatakanaMemorised() {
          return allKatakanaMemorised;
     }

     public static boolean isAllKanjiMemorised() {
          return allKanjiMemorised;
     }

     public static Array<Integer> getHiraganaList() {
          hiraganaList = new Array<Integer>();

          hiraganaList.add(hiraganaALvl);
          hiraganaList.add(hiraganaILvl);
          hiraganaList.add(hiraganaULvl);
          hiraganaList.add(hiraganaELvl);
          hiraganaList.add(hiraganaOLvl);
          hiraganaList.add(hiraganaKaLvl);
          hiraganaList.add(hiraganaKiLvl);
          hiraganaList.add(hiraganaKuLvl);
          hiraganaList.add(hiraganaKeLvl);
          hiraganaList.add(hiraganaKoLvl);
          hiraganaList.add(hiraganaSaLvl);
          hiraganaList.add(hiraganaShiLvl);
          hiraganaList.add(hiraganaSuLvl);
          hiraganaList.add(hiraganaSeLvl);
          hiraganaList.add(hiraganaSoLvl);
          hiraganaList.add(hiraganaTaLvl);
          hiraganaList.add(hiraganaChiLvl);
          hiraganaList.add(hiraganaTsuLvl);
          hiraganaList.add(hiraganaTeLvl);
          hiraganaList.add(hiraganaToLvl);
          hiraganaList.add(hiraganaNaLvl);
          hiraganaList.add(hiraganaNiLvl);
          hiraganaList.add(hiraganaNuLvl);
          hiraganaList.add(hiraganaNeLvl);
          hiraganaList.add(hiraganaNoLvl);
          hiraganaList.add(hiraganaHaLvl);
          hiraganaList.add(hiraganaHiLvl);
          hiraganaList.add(hiraganaHuLvl);
          hiraganaList.add(hiraganaHeLvl);
          hiraganaList.add(hiraganaHoLvl);
          hiraganaList.add(hiraganaMaLvl);
          hiraganaList.add(hiraganaMiLvl);
          hiraganaList.add(hiraganaMuLvl);
          hiraganaList.add(hiraganaMeLvl);
          hiraganaList.add(hiraganaMoLvl);
          hiraganaList.add(hiraganaRaLvl);
          hiraganaList.add(hiraganaRiLvl);
          hiraganaList.add(hiraganaRuLvl);
          hiraganaList.add(hiraganaReLvl);
          hiraganaList.add(hiraganaRoLvl);
          hiraganaList.add(hiraganaYuLvl);
          hiraganaList.add(hiraganaYoLvl);
          hiraganaList.add(hiraganaWaLvl);
          hiraganaList.add(hiraganaWoLvl);
          hiraganaList.add(hiraganaNLvl);
          hiraganaList.add(hiraganaGaLvl);
          hiraganaList.add(hiraganaGiLvl);
          hiraganaList.add(hiraganaGuLvl);
          hiraganaList.add(hiraganaGeLvl);
          hiraganaList.add(hiraganaGoLvl);
          hiraganaList.add(hiraganaZaLvl);
          hiraganaList.add(hiraganaJiLvl);
          hiraganaList.add(hiraganaZuLvl);
          hiraganaList.add(hiraganaZeLvl);
          hiraganaList.add(hiraganaZoLvl);
          hiraganaList.add(hiraganaDaLvl);
          hiraganaList.add(hiraganaDiLvl);
          hiraganaList.add(hiraganaDuLvl);
          hiraganaList.add(hiraganaDeLvl);
          hiraganaList.add(hiraganaDoLvl);
          hiraganaList.add(hiraganaBaLvl);
          hiraganaList.add(hiraganaBiLvl);
          hiraganaList.add(hiraganaBuLvl);
          hiraganaList.add(hiraganaBeLvl);
          hiraganaList.add(hiraganaBoLvl);
          hiraganaList.add(hiraganaPaLvl);
          hiraganaList.add(hiraganaPiLvl);
          hiraganaList.add(hiraganaPuLvl);
          hiraganaList.add(hiraganaPeLvl);
          hiraganaList.add(hiraganaPoLvl);
          hiraganaList.add(hiraganaYaLvl);
          hiraganaList.add(hiraganaKyaLvl);
          hiraganaList.add(hiraganaKyuLvl);
          hiraganaList.add(hiraganaKyoLvl);
          hiraganaList.add(hiraganaShaLvl);
          hiraganaList.add(hiraganaShuLvl);
          hiraganaList.add(hiraganaShoLvl);
          hiraganaList.add(hiraganaChaLvl);
          hiraganaList.add(hiraganaChuLvl);
          hiraganaList.add(hiraganaChoLvl);
          hiraganaList.add(hiraganaHyaLvl);
          hiraganaList.add(hiraganaHyuLvl);
          hiraganaList.add(hiraganaHyoLvl);
          hiraganaList.add(hiraganaNyaLvl);
          hiraganaList.add(hiraganaNyuLvl);
          hiraganaList.add(hiraganaNyoLvl);
          hiraganaList.add(hiraganaMyaLvl);
          hiraganaList.add(hiraganaMyuLvl);
          hiraganaList.add(hiraganaMyoLvl);
          hiraganaList.add(hiraganaRyaLvl);
          hiraganaList.add(hiraganaRyuLvl);
          hiraganaList.add(hiraganaRyoLvl);
          hiraganaList.add(hiraganaGyaLvl);
          hiraganaList.add(hiraganaGyuLvl);
          hiraganaList.add(hiraganaGyoLvl);
          hiraganaList.add(hiraganaJyaLvl);
          hiraganaList.add(hiraganaJyuLvl);
          hiraganaList.add(hiraganaJyoLvl);
          hiraganaList.add(hiraganaDyaLvl);
          hiraganaList.add(hiraganaDyuLvl);
          hiraganaList.add(hiraganaDyoLvl);
          hiraganaList.add(hiraganaByaLvl);
          hiraganaList.add(hiraganaByuLvl);
          hiraganaList.add(hiraganaByoLvl);
          hiraganaList.add(hiraganaPyaLvl);
          hiraganaList.add(hiraganaPyuLvl);
          hiraganaList.add(hiraganaPyoLvl);

          return hiraganaList;
     }

     public static Array<Integer> getKatakanaList() {
          katakanaList = new Array<Integer>();

          katakanaList.add(katakanaALvl);
          katakanaList.add(katakanaILvl);
          katakanaList.add(katakanaULvl);
          katakanaList.add(katakanaELvl);
          katakanaList.add(katakanaOLvl);
          katakanaList.add(katakanaKaLvl);
          katakanaList.add(katakanaKiLvl);
          katakanaList.add(katakanaKuLvl);
          katakanaList.add(katakanaKeLvl);
          katakanaList.add(katakanaKoLvl);
          katakanaList.add(katakanaSaLvl);
          katakanaList.add(katakanaShiLvl);
          katakanaList.add(katakanaSuLvl);
          katakanaList.add(katakanaSeLvl);
          katakanaList.add(katakanaSoLvl);
          katakanaList.add(katakanaTaLvl);
          katakanaList.add(katakanaChiLvl);
          katakanaList.add(katakanaTsuLvl);
          katakanaList.add(katakanaTeLvl);
          katakanaList.add(katakanaToLvl);
          katakanaList.add(katakanaNaLvl);
          katakanaList.add(katakanaNiLvl);
          katakanaList.add(katakanaNuLvl);
          katakanaList.add(katakanaNeLvl);
          katakanaList.add(katakanaNoLvl);
          katakanaList.add(katakanaHaLvl);
          katakanaList.add(katakanaHiLvl);
          katakanaList.add(katakanaHuLvl);
          katakanaList.add(katakanaHeLvl);
          katakanaList.add(katakanaHoLvl);
          katakanaList.add(katakanaMaLvl);
          katakanaList.add(katakanaMiLvl);
          katakanaList.add(katakanaMuLvl);
          katakanaList.add(katakanaMeLvl);
          katakanaList.add(katakanaMoLvl);
          katakanaList.add(katakanaRaLvl);
          katakanaList.add(katakanaRiLvl);
          katakanaList.add(katakanaRuLvl);
          katakanaList.add(katakanaReLvl);
          katakanaList.add(katakanaRoLvl);
          katakanaList.add(katakanaYuLvl);
          katakanaList.add(katakanaYoLvl);
          katakanaList.add(katakanaWaLvl);
          katakanaList.add(katakanaWoLvl);
          katakanaList.add(katakanaNLvl);
          katakanaList.add(katakanaGaLvl);
          katakanaList.add(katakanaGiLvl);
          katakanaList.add(katakanaGuLvl);
          katakanaList.add(katakanaGeLvl);
          katakanaList.add(katakanaGoLvl);
          katakanaList.add(katakanaZaLvl);
          katakanaList.add(katakanaJiLvl);
          katakanaList.add(katakanaZuLvl);
          katakanaList.add(katakanaZeLvl);
          katakanaList.add(katakanaZoLvl);
          katakanaList.add(katakanaDaLvl);
          katakanaList.add(katakanaDiLvl);
          katakanaList.add(katakanaDuLvl);
          katakanaList.add(katakanaDeLvl);
          katakanaList.add(katakanaDoLvl);
          katakanaList.add(katakanaBaLvl);
          katakanaList.add(katakanaBiLvl);
          katakanaList.add(katakanaBuLvl);
          katakanaList.add(katakanaBeLvl);
          katakanaList.add(katakanaBoLvl);
          katakanaList.add(katakanaPaLvl);
          katakanaList.add(katakanaPiLvl);
          katakanaList.add(katakanaPuLvl);
          katakanaList.add(katakanaPeLvl);
          katakanaList.add(katakanaPoLvl);
          katakanaList.add(katakanaYaLvl);
          katakanaList.add(katakanaKyaLvl);
          katakanaList.add(katakanaKyuLvl);
          katakanaList.add(katakanaKyoLvl);
          katakanaList.add(katakanaShaLvl);
          katakanaList.add(katakanaShuLvl);
          katakanaList.add(katakanaShoLvl);
          katakanaList.add(katakanaChaLvl);
          katakanaList.add(katakanaChuLvl);
          katakanaList.add(katakanaChoLvl);
          katakanaList.add(katakanaHyaLvl);
          katakanaList.add(katakanaHyuLvl);
          katakanaList.add(katakanaHyoLvl);
          katakanaList.add(katakanaNyaLvl);
          katakanaList.add(katakanaNyuLvl);
          katakanaList.add(katakanaNyoLvl);
          katakanaList.add(katakanaMyaLvl);
          katakanaList.add(katakanaMyuLvl);
          katakanaList.add(katakanaMyoLvl);
          katakanaList.add(katakanaRyaLvl);
          katakanaList.add(katakanaRyuLvl);
          katakanaList.add(katakanaRyoLvl);
          katakanaList.add(katakanaGyaLvl);
          katakanaList.add(katakanaGyuLvl);
          katakanaList.add(katakanaGyoLvl);
          katakanaList.add(katakanaJyaLvl);
          katakanaList.add(katakanaJyuLvl);
          katakanaList.add(katakanaJyoLvl);
          katakanaList.add(katakanaDyaLvl);
          katakanaList.add(katakanaDyuLvl);
          katakanaList.add(katakanaDyoLvl);
          katakanaList.add(katakanaByaLvl);
          katakanaList.add(katakanaByuLvl);
          katakanaList.add(katakanaByoLvl);
          katakanaList.add(katakanaPyaLvl);
          katakanaList.add(katakanaPyuLvl);
          katakanaList.add(katakanaPyoLvl);

          return katakanaList;
     }

     public static Array<Integer> getKanjiList() {

          kanjiList = new Array<Integer>();

           kanjiList.add( kanjiHaLvl);
           kanjiList.add( kanjiKiLvl);
           kanjiList.add( kanjiMushiLvl);
           kanjiList.add( kanjiKazeLvl);
           kanjiList.add(kanjiTsuchiLvl);
           kanjiList.add( kanjiUchiLvl);
           kanjiList.add( kanjiUmiLvl);
           kanjiList.add( kanjiMizuLvl);
           kanjiList.add( kanjiIkeLvl);
           kanjiList.add( kanjiKooriLvl);
           kanjiList.add(kanjiHayashiLvl);
           kanjiList.add( kanjiToLvl);
           kanjiList.add( kanjiTeraLvl);
           kanjiList.add( kanjiSotoLvl);
           kanjiList.add( kanjiHiLvl);
           kanjiList.add( kanjiAkaLvl);
           kanjiList.add( kanjiHanaLvl);
           kanjiList.add( kanjiMoriLvl);
           kanjiList.add( kanjiIshiLvl);
           kanjiList.add( kanjiYamaLvl);
           kanjiList.add(kanjiSakanaLvl);
           kanjiList.add( kanjiKaiLvl);
           kanjiList.add( kanjiYukiLvl);
           kanjiList.add( kanjiKawaLvl);
           kanjiList.add( kanjiFuyuLvl);
           kanjiList.add( kanjiMonLvl);
           kanjiList.add( kanjiAnaLvl);
           kanjiList.add( kanjiKaLvl);
           kanjiList.add( kanjiChiLvl);
           kanjiList.add(kanjiHikariLvl);


          return kanjiList;
     }

     public static void adjustLvl(String letter, int addOn){
          switch (letter){
               case "hiraganaA":         hiraganaALvl = addOn;    break;
               case "hiraganaI":         hiraganaILvl = addOn;    break;
               case "hiraganaU":         hiraganaULvl = addOn;    break;
               case "hiraganaE":         hiraganaELvl = addOn;    break;
               case "hiraganaO":         hiraganaOLvl = addOn;    break;
               case "hiraganaKa":       hiraganaKaLvl = addOn;    break;
               case "hiraganaKi":       hiraganaKiLvl = addOn;    break;
               case "hiraganaKu":       hiraganaKuLvl = addOn;    break;
               case "hiraganaKe":       hiraganaKeLvl = addOn;    break;
               case "hiraganaKo":       hiraganaKoLvl = addOn;    break;
               case "hiraganaSa":       hiraganaSaLvl = addOn;    break;
               case "hiraganaShi":     hiraganaShiLvl = addOn;    break;
               case "hiraganaSu":       hiraganaSuLvl = addOn;    break;
               case "hiraganaSe":       hiraganaSeLvl = addOn;    break;
               case "hiraganaSo":       hiraganaSoLvl = addOn;    break;
               case "hiraganaTa":       hiraganaTaLvl = addOn;    break;
               case "hiraganaChi":     hiraganaChiLvl = addOn;    break;
               case "hiraganaTsu":     hiraganaTsuLvl = addOn;    break;
               case "hiraganaTe":       hiraganaTeLvl = addOn;    break;
               case "hiraganaTo":       hiraganaToLvl = addOn;    break;
               case "hiraganaNa":       hiraganaNaLvl = addOn;    break;
               case "hiraganaNi":       hiraganaNiLvl = addOn;    break;
               case "hiraganaNu":       hiraganaNuLvl = addOn;    break;
               case "hiraganaNe":       hiraganaNeLvl = addOn;    break;
               case "hiraganaNo":       hiraganaNoLvl = addOn;    break;
               case "hiraganaHa":       hiraganaHaLvl = addOn;    break;
               case "hiraganaHi":       hiraganaHiLvl = addOn;    break;
               case "hiraganaHu":       hiraganaHuLvl = addOn;    break;
               case "hiraganaHe":       hiraganaHeLvl = addOn;    break;
               case "hiraganaHo":       hiraganaHoLvl = addOn;    break;
               case "hiraganaMa":       hiraganaMaLvl = addOn;    break;
               case "hiraganaMi":       hiraganaMiLvl = addOn;    break;
               case "hiraganaMu":       hiraganaMuLvl = addOn;    break;
               case "hiraganaMe":       hiraganaMeLvl = addOn;    break;
               case "hiraganaMo":       hiraganaMoLvl = addOn;    break;
               case "hiraganaRa":       hiraganaRaLvl = addOn;    break;
               case "hiraganaRi":       hiraganaRiLvl = addOn;    break;
               case "hiraganaRu":       hiraganaRuLvl = addOn;    break;
               case "hiraganaRe":       hiraganaReLvl = addOn;    break;
               case "hiraganaRo":       hiraganaRoLvl = addOn;    break;
               case "hiraganaYa":       hiraganaYaLvl = addOn;    break;
               case "hiraganaYu":       hiraganaYuLvl = addOn;    break;
               case "hiraganaYo":       hiraganaYoLvl = addOn;    break;
               case "hiraganaWa":       hiraganaWaLvl = addOn;    break;
               case "hiraganaWo":       hiraganaWoLvl = addOn;    break;
               case "hiraganaN":         hiraganaNLvl = addOn;    break;
               case "hiraganaGa":       hiraganaGaLvl = addOn;    break;
               case "hiraganaGi":       hiraganaGiLvl = addOn;    break;
               case "hiraganaGu":       hiraganaGuLvl = addOn;    break;
               case "hiraganaGe":       hiraganaGeLvl = addOn;    break;
               case "hiraganaGo":       hiraganaGoLvl = addOn;    break;
               case "hiraganaZa":       hiraganaZaLvl = addOn;    break;
               case "hiraganaJi":       hiraganaJiLvl = addOn;    break;
               case "hiraganaZu":       hiraganaZuLvl = addOn;    break;
               case "hiraganaZe":       hiraganaZeLvl = addOn;    break;
               case "hiraganaZo":       hiraganaZoLvl = addOn;    break;
               case "hiraganaDa":       hiraganaDaLvl = addOn;    break;
               case "hiraganaDi":       hiraganaDiLvl = addOn;    break;
               case "hiraganaDu":       hiraganaDuLvl = addOn;    break;
               case "hiraganaDe":       hiraganaDeLvl = addOn;    break;
               case "hiraganaDo":       hiraganaDoLvl = addOn;    break;
               case "hiraganaBa":       hiraganaBaLvl = addOn;    break;
               case "hiraganaBi":       hiraganaBiLvl = addOn;    break;
               case "hiraganaBu":       hiraganaBuLvl = addOn;    break;
               case "hiraganaBe":       hiraganaBeLvl = addOn;    break;
               case "hiraganaBo":       hiraganaBoLvl = addOn;    break;
               case "hiraganaPa":       hiraganaPaLvl = addOn;    break;
               case "hiraganaPi":       hiraganaPiLvl = addOn;    break;
               case "hiraganaPu":       hiraganaPuLvl = addOn;    break;
               case "hiraganaPe":       hiraganaPeLvl = addOn;    break;
               case "hiraganaPo":       hiraganaPoLvl = addOn;    break;
               case "hiraganaKya":     hiraganaKyaLvl = addOn;    break;
               case "hiraganaKyu":     hiraganaKyuLvl = addOn;    break;
               case "hiraganaKyo":     hiraganaKyoLvl = addOn;    break;
               case "hiraganaSha":     hiraganaShaLvl = addOn;    break;
               case "hiraganaShu":     hiraganaShuLvl = addOn;    break;
               case "hiraganaSho":     hiraganaShoLvl = addOn;    break;
               case "hiraganaCha":     hiraganaChaLvl = addOn;    break;
               case "hiraganaChu":     hiraganaChuLvl = addOn;    break;
               case "hiraganaCho":     hiraganaChoLvl = addOn;    break;
               case "hiraganaHya":     hiraganaHyaLvl = addOn;    break;
               case "hiraganaHyu":     hiraganaHyuLvl = addOn;    break;
               case "hiraganaHyo":     hiraganaHyoLvl = addOn;    break;
               case "hiraganaNya":     hiraganaNyaLvl = addOn;    break;
               case "hiraganaNyu":     hiraganaNyuLvl = addOn;    break;
               case "hiraganaNyo":     hiraganaNyoLvl = addOn;    break;
               case "hiraganaMya":     hiraganaMyaLvl = addOn;    break;
               case "hiraganaMyu":     hiraganaMyuLvl = addOn;    break;
               case "hiraganaMyo":     hiraganaMyoLvl = addOn;    break;
               case "hiraganaRya":     hiraganaRyaLvl = addOn;    break;
               case "hiraganaRyu":     hiraganaRyuLvl = addOn;    break;
               case "hiraganaRyo":     hiraganaRyoLvl = addOn;    break;
               case "hiraganaGya":     hiraganaGyaLvl = addOn;    break;
               case "hiraganaGyu":     hiraganaGyuLvl = addOn;    break;
               case "hiraganaGyo":     hiraganaGyoLvl = addOn;    break;
               case "hiraganaJya":     hiraganaJyaLvl = addOn;    break;
               case "hiraganaJyu":     hiraganaJyuLvl = addOn;    break;
               case "hiraganaJyo":     hiraganaJyoLvl = addOn;    break;
               case "hiraganaDya":     hiraganaDyaLvl = addOn;    break;
               case "hiraganaDyu":     hiraganaDyuLvl = addOn;    break;
               case "hiraganaDyo":     hiraganaDyoLvl = addOn;    break;
               case "hiraganaBya":     hiraganaByaLvl = addOn;    break;
               case "hiraganaByu":     hiraganaByuLvl = addOn;    break;
               case "hiraganaByo":     hiraganaByoLvl = addOn;    break;
               case "hiraganaPya":     hiraganaPyaLvl = addOn;    break;
               case "hiraganaPyu":     hiraganaPyuLvl = addOn;    break;
               case "hiraganaPyo":     hiraganaPyoLvl = addOn;    break;
               case "katakanaA":         katakanaALvl = addOn;    break;
               case "katakanaI":         katakanaILvl = addOn;    break;
               case "katakanaU":         katakanaULvl = addOn;    break;
               case "katakanaE":         katakanaELvl = addOn;    break;
               case "katakanaO":         katakanaOLvl = addOn;    break;
               case "katakanaKa":       katakanaKaLvl = addOn;    break;
               case "katakanaKi":       katakanaKiLvl = addOn;    break;
               case "katakanaKu":       katakanaKuLvl = addOn;    break;
               case "katakanaKe":       katakanaKeLvl = addOn;    break;
               case "katakanaKo":       katakanaKoLvl = addOn;    break;
               case "katakanaSa":       katakanaSaLvl = addOn;    break;
               case "katakanaLvlShi":  katakanaShiLvl = addOn;    break;
               case "katakanaLvlSu":   katakanaSuLvl  = addOn;    break;
               case "katakanaLvlSe":    katakanaSeLvl = addOn;    break;
               case "katakanaLvlSo":    katakanaSoLvl = addOn;    break;
               case "katakanaLvlTa":    katakanaTaLvl = addOn;    break;
               case "katakanaLvlChi":  katakanaChiLvl = addOn;    break;
               case "katakanaLvlTsu":  katakanaTsuLvl = addOn;    break;
               case "katakanaLvlTe":    katakanaTeLvl = addOn;    break;
               case "katakanaLvlTo":    katakanaToLvl = addOn;    break;
               case "katakanaLvlNa":    katakanaNaLvl = addOn;    break;
               case "katakanaLvlNi":    katakanaNiLvl = addOn;    break;
               case "katakanaLvlNu":    katakanaNuLvl = addOn;    break;
               case "katakanaLvlNe":    katakanaNeLvl = addOn;    break;
               case "katakanaLvlNo":    katakanaNoLvl = addOn;    break;
               case "katakanaLvlHa":    katakanaHaLvl = addOn;    break;
               case "katakanaLvlHi":    katakanaHiLvl = addOn;    break;
               case "katakanaLvlHu":    katakanaHuLvl = addOn;    break;
               case "katakanaLvlHe":    katakanaHeLvl = addOn;    break;
               case "katakanaLvlHo":    katakanaHoLvl = addOn;    break;
               case "katakanaLvlMa":    katakanaMaLvl = addOn;    break;
               case "katakanaLvlMi":    katakanaMiLvl = addOn;    break;
               case "katakanaLvlMu":    katakanaMuLvl = addOn;    break;
               case "katakanaLvlMe":    katakanaMeLvl = addOn;    break;
               case "katakanaLvlMo":    katakanaMoLvl = addOn;    break;
               case "katakanaLvlRa":    katakanaRaLvl = addOn;    break;
               case "katakanaLvlRi":    katakanaRiLvl = addOn;    break;
               case "katakanaLvlRu":    katakanaRuLvl = addOn;    break;
               case "katakanaLvlRe":    katakanaReLvl = addOn;    break;
               case "katakanaLvlRo":    katakanaRoLvl = addOn;    break;
               case "katakanaLvlYa":    katakanaYaLvl = addOn;    break;
               case "katakanaLvlYu":    katakanaYuLvl = addOn;    break;
               case "katakanaLvlYo":    katakanaYoLvl = addOn;    break;
               case "katakanaLvlWa":    katakanaWaLvl = addOn;    break;
               case "katakanaLvlWo":    katakanaWoLvl = addOn;    break;
               case "katakanaLvlN":      katakanaNLvl = addOn;    break;
               case "katakanaLvlGa":    katakanaGaLvl = addOn;    break;
               case "katakanaLvlGi":    katakanaGiLvl = addOn;    break;
               case "katakanaLvlGu":    katakanaGuLvl = addOn;    break;
               case "katakanaLvlGe":    katakanaGeLvl = addOn;    break;
               case "katakanaLvlGo":    katakanaGoLvl = addOn;    break;
               case "katakanaLvlZa":    katakanaZaLvl = addOn;    break;
               case "katakanaLvlJi":    katakanaJiLvl = addOn;    break;
               case "katakanaLvlZu":    katakanaZuLvl = addOn;    break;
               case "katakanaLvlZe":    katakanaZeLvl = addOn;    break;
               case "katakanaLvlZo":    katakanaZoLvl = addOn;    break;
               case "katakanaLvlDa":    katakanaDaLvl = addOn;    break;
               case "katakanaLvlDi":    katakanaDiLvl = addOn;    break;
               case "katakanaLvlDu":    katakanaDuLvl = addOn;    break;
               case "katakanaLvlDe":    katakanaDeLvl = addOn;    break;
               case "katakanaLvlDo":    katakanaDoLvl = addOn;    break;
               case "katakanaLvlBa":    katakanaBaLvl = addOn;    break;
               case "katakanaLvlBi":    katakanaBiLvl = addOn;    break;
               case "katakanaLvlBu":    katakanaBuLvl = addOn;    break;
               case "katakanaLvlBe":    katakanaBeLvl = addOn;    break;
               case "katakanaLvlBo":    katakanaBoLvl = addOn;    break;
               case "katakanaLvlPa":    katakanaPaLvl = addOn;    break;
               case "katakanaLvlPi":    katakanaPiLvl = addOn;    break;
               case "katakanaLvlPu":    katakanaPuLvl = addOn;    break;
               case "katakanaLvlPe":    katakanaPeLvl = addOn;    break;
               case "katakanaLvlPo":    katakanaPoLvl = addOn;    break;
               case "katakanaLvlKya":  katakanaKyaLvl = addOn;    break;
               case "katakanaLvlKyu":  katakanaKyuLvl = addOn;    break;
               case "katakanaLvlKyo":  katakanaKyoLvl = addOn;    break;
               case "katakanaLvlSha":  katakanaShaLvl = addOn;    break;
               case "katakanaLvlShu":  katakanaShuLvl = addOn;    break;
               case "katakanaLvlSho":  katakanaShoLvl = addOn;    break;
               case "katakanaLvlCha":  katakanaChaLvl = addOn;    break;
               case "katakanaLvlChu":  katakanaChuLvl = addOn;    break;
               case "katakanaLvlCho":  katakanaChoLvl = addOn;    break;
               case "katakanaLvlHya":  katakanaHyaLvl = addOn;    break;
               case "katakanaLvlHyu":  katakanaHyuLvl = addOn;    break;
               case "katakanaLvlHyo":  katakanaHyoLvl = addOn;    break;
               case "katakanaLvlNya":  katakanaNyaLvl = addOn;    break;
               case "katakanaLvlNyu":  katakanaNyuLvl = addOn;    break;
               case "katakanaLvlNyo":  katakanaNyoLvl = addOn;    break;
               case "katakanaLvlMya":  katakanaMyaLvl = addOn;    break;
               case "katakanaLvlMyu":  katakanaMyuLvl = addOn;    break;
               case "katakanaLvlMyo":  katakanaMyoLvl = addOn;    break;
               case "katakanaLvlRya":  katakanaRyaLvl = addOn;    break;
               case "katakanaLvlRyu":  katakanaRyuLvl = addOn;    break;
               case "katakanaLvlRyo":  katakanaRyoLvl = addOn;    break;
               case "katakanaLvlGya":  katakanaGyaLvl = addOn;    break;
               case "katakanaLvlGyu":  katakanaGyuLvl = addOn;    break;
               case "katakanaLvlGyo":  katakanaGyoLvl = addOn;    break;
               case "katakanaLvlJya":  katakanaJyaLvl = addOn;    break;
               case "katakanaLvlJyu":  katakanaJyuLvl = addOn;    break;
               case "katakanaLvlJyo":  katakanaJyoLvl = addOn;    break;
               case "katakanaLvlDya":  katakanaDyaLvl = addOn;    break;
               case "katakanaLvlDyu":  katakanaDyuLvl = addOn;    break;
               case "katakanaLvlDyo":  katakanaDyoLvl = addOn;    break;
               case "katakanaLvlBya":  katakanaByaLvl = addOn;    break;
               case "katakanaLvlByu":  katakanaByuLvl = addOn;    break;
               case "katakanaLvlByo":  katakanaByoLvl = addOn;    break;
               case "katakanaLvlPya":  katakanaPyaLvl = addOn;    break;
               case "katakanaLvlPyu":  katakanaPyuLvl = addOn;    break;
               case "katakanaLvlPyo":  katakanaPyoLvl = addOn;    break;
               case "kanjiHa":          kanjiHaLvl = addOn; break;
               case "kanjiHana":          kanjiKiLvl = addOn; break;
               case "kanjiKi":    kanjiMushiLvl = addOn; break;
               case "kanjiMori":      kanjiKazeLvl = addOn; break;
               case "kanjiMushi":      kanjiKazeLvl = addOn; break;
               case "kanjiIshi":      kanjiUchiLvl = addOn; break;
               case "kanjiKaze":        kanjiUmiLvl = addOn; break;
               case "kanjiTsuchi":      kanjiMizuLvl = addOn; break;
               case "kanjiUchi":        kanjiIkeLvl = addOn; break;
               case "kanjiYama":    kanjiKooriLvl = addOn; break;
               case "kanjiUmi":  kanjiHayashiLvl = addOn; break;
               case "kanjiSakana":          kanjiToLvl = addOn; break;
               case "kanjiMizu":      kanjiTeraLvl = addOn; break;
               case "kanjiKai":      kanjiSotoLvl = addOn; break;
               case "kanjiIke":          kanjiHiLvl = addOn; break;
               case "kanjiYuki":        kanjiAkaLvl = addOn; break;
               case "kanjiKoori":      kanjiHanaLvl = addOn; break;
               case "kanjiKawa":      kanjiMoriLvl = addOn; break;
               case "kanjiHayashi":      kanjiIshiLvl = addOn; break;
               case "kanjiFuyu":    kanjiTsuchiLvl = addOn;  break;
               case "kanjiTo":      kanjiYamaLvl = addOn; break;
               case "kanjiMon":  kanjiSakanaLvl = addOn; break;
               case "kanjiTera":        kanjiKaiLvl = addOn; break;
               case "kanjiAna":      kanjiYukiLvl = addOn; break;
               case "kanjiSoto":      kanjiKawaLvl = addOn; break;
               case "kanjiKa":      kanjiFuyuLvl = addOn; break;
               case "kanjiHi":        kanjiMonLvl = addOn; break;
               case "kanjiChi":        kanjiAnaLvl = addOn; break;
               case "kanjiAka":          kanjiKaLvl = addOn; break;
               case "kanjiHikari":        kanjiChiLvl = addOn; break;
               default: break;

          }
     }
}
