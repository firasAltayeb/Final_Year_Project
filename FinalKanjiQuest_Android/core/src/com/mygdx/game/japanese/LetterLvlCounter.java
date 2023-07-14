package com.mygdx.game.japanese;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import java.util.Hashtable;

/**
 * Created by firasAltayeb on 17/14/2117.
 */

public class LetterLvlCounter {

     private final static String TAG = LetterLvlCounter.class.getSimpleName();

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
          Gdx.app.log(TAG, "Kana Answered is " + letter);
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
               case "katakanaA":         katakanaALvl = MathUtils.clamp(addOn +    katakanaALvl, 1, 4);
                    Gdx.app.log(TAG, "Kana katakanaALvl lvl is " + katakanaALvl);
                    break;
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
               case "katakanaShi":  katakanaShiLvl = MathUtils.clamp(addOn +  katakanaShiLvl, 1, 4);    break;
               case "katakanaSu":   katakanaSuLvl = MathUtils.clamp(addOn +    katakanaSuLvl, 1, 4);    break;
               case "katakanaSe":    katakanaSeLvl = MathUtils.clamp(addOn +   katakanaSeLvl, 1, 4);    break;
               case "katakanaSo":    katakanaSoLvl = MathUtils.clamp(addOn +   katakanaSoLvl, 1, 4);    break;
               case "katakanaTa":    katakanaTaLvl = MathUtils.clamp(addOn +   katakanaTaLvl, 1, 4);    break;
               case "katakanaChi":  katakanaChiLvl = MathUtils.clamp(addOn +  katakanaChiLvl, 1, 4);    break;
               case "katakanaTsu":  katakanaTsuLvl = MathUtils.clamp(addOn +  katakanaTsuLvl, 1, 4);    break;
               case "katakanaTe":    katakanaTeLvl = MathUtils.clamp(addOn +   katakanaTeLvl, 1, 4);    break;
               case "katakanaTo":    katakanaToLvl = MathUtils.clamp(addOn +   katakanaToLvl, 1, 4);    break;
               case "katakanaNa":    katakanaNaLvl = MathUtils.clamp(addOn +   katakanaNaLvl, 1, 4);    break;
               case "katakanaNi":    katakanaNiLvl = MathUtils.clamp(addOn +   katakanaNiLvl, 1, 4);    break;
               case "katakanaNu":    katakanaNuLvl = MathUtils.clamp(addOn +   katakanaNuLvl, 1, 4);    break;
               case "katakanaNe":    katakanaNeLvl = MathUtils.clamp(addOn +   katakanaNeLvl, 1, 4);    break;
               case "katakanaNo":    katakanaNoLvl = MathUtils.clamp(addOn +   katakanaNoLvl, 1, 4);    break;
               case "katakanaHa":    katakanaHaLvl = MathUtils.clamp(addOn +   katakanaHaLvl, 1, 4);    break;
               case "katakanaHi":    katakanaHiLvl = MathUtils.clamp(addOn +   katakanaHiLvl, 1, 4);    break;
               case "katakanaHu":    katakanaHuLvl = MathUtils.clamp(addOn +   katakanaHuLvl, 1, 4);    break;
               case "katakanaHe":    katakanaHeLvl = MathUtils.clamp(addOn +   katakanaHeLvl, 1, 4);    break;
               case "katakanaHo":    katakanaHoLvl = MathUtils.clamp(addOn +   katakanaHoLvl, 1, 4);    break;
               case "katakanaMa":    katakanaMaLvl = MathUtils.clamp(addOn +   katakanaMaLvl, 1, 4);    break;
               case "katakanaMi":    katakanaMiLvl = MathUtils.clamp(addOn +   katakanaMiLvl, 1, 4);    break;
               case "katakanaMu":    katakanaMuLvl = MathUtils.clamp(addOn +   katakanaMuLvl, 1, 4);    break;
               case "katakanaMe":    katakanaMeLvl = MathUtils.clamp(addOn +   katakanaMeLvl, 1, 4);    break;
               case "katakanaMo":    katakanaMoLvl = MathUtils.clamp(addOn +   katakanaMoLvl, 1, 4);    break;
               case "katakanaRa":    katakanaRaLvl = MathUtils.clamp(addOn +   katakanaRaLvl, 1, 4);    break;
               case "katakanaRi":    katakanaRiLvl = MathUtils.clamp(addOn +   katakanaRiLvl, 1, 4);    break;
               case "katakanaRu":    katakanaRuLvl = MathUtils.clamp(addOn +   katakanaRuLvl, 1, 4);    break;
               case "katakanaRe":    katakanaReLvl = MathUtils.clamp(addOn +   katakanaReLvl, 1, 4);    break;
               case "katakanaRo":    katakanaRoLvl = MathUtils.clamp(addOn +   katakanaRoLvl, 1, 4);    break;
               case "katakanaYa":    katakanaYaLvl = MathUtils.clamp(addOn +   katakanaYaLvl, 1, 4);    break;
               case "katakanaYu":    katakanaYuLvl = MathUtils.clamp(addOn +   katakanaYuLvl, 1, 4);    break;
               case "katakanaYo":    katakanaYoLvl = MathUtils.clamp(addOn +   katakanaYoLvl, 1, 4);    break;
               case "katakanaWa":    katakanaWaLvl = MathUtils.clamp(addOn +   katakanaWaLvl, 1, 4);    break;
               case "katakanaWo":    katakanaWoLvl = MathUtils.clamp(addOn +   katakanaWoLvl, 1, 4);    break;
               case "katakanaN":      katakanaNLvl = MathUtils.clamp(addOn +    katakanaNLvl, 1, 4);    break;
               case "katakanaGa":    katakanaGaLvl = MathUtils.clamp(addOn +   katakanaGaLvl, 1, 4);    break;
               case "katakanaGi":    katakanaGiLvl = MathUtils.clamp(addOn +   katakanaGiLvl, 1, 4);    break;
               case "katakanaGu":    katakanaGuLvl = MathUtils.clamp(addOn +   katakanaGuLvl, 1, 4);    break;
               case "katakanaGe":    katakanaGeLvl = MathUtils.clamp(addOn +   katakanaGeLvl, 1, 4);    break;
               case "katakanaGo":    katakanaGoLvl = MathUtils.clamp(addOn +   katakanaGoLvl, 1, 4);    break;
               case "katakanaZa":    katakanaZaLvl = MathUtils.clamp(addOn +   katakanaZaLvl, 1, 4);    break;
               case "katakanaJi":    katakanaJiLvl = MathUtils.clamp(addOn +   katakanaJiLvl, 1, 4);    break;
               case "katakanaZu":    katakanaZuLvl = MathUtils.clamp(addOn +   katakanaZuLvl, 1, 4);    break;
               case "katakanaZe":    katakanaZeLvl = MathUtils.clamp(addOn +   katakanaZeLvl, 1, 4);    break;
               case "katakanaZo":    katakanaZoLvl = MathUtils.clamp(addOn +   katakanaZoLvl, 1, 4);    break;
               case "katakanaDa":    katakanaDaLvl = MathUtils.clamp(addOn +   katakanaDaLvl, 1, 4);    break;
               case "katakanaDi":    katakanaDiLvl = MathUtils.clamp(addOn +   katakanaDiLvl, 1, 4);    break;
               case "katakanaDu":    katakanaDuLvl = MathUtils.clamp(addOn +   katakanaDuLvl, 1, 4);    break;
               case "katakanaDe":    katakanaDeLvl = MathUtils.clamp(addOn +   katakanaDeLvl, 1, 4);    break;
               case "katakanaDo":    katakanaDoLvl = MathUtils.clamp(addOn +   katakanaDoLvl, 1, 4);    break;
               case "katakanaBa":    katakanaBaLvl = MathUtils.clamp(addOn +   katakanaBaLvl, 1, 4);    break;
               case "katakanaBi":    katakanaBiLvl = MathUtils.clamp(addOn +   katakanaBiLvl, 1, 4);    break;
               case "katakanaBu":    katakanaBuLvl = MathUtils.clamp(addOn +   katakanaBuLvl, 1, 4);    break;
               case "katakanaBe":    katakanaBeLvl = MathUtils.clamp(addOn +   katakanaBeLvl, 1, 4);    break;
               case "katakanaBo":    katakanaBoLvl = MathUtils.clamp(addOn +   katakanaBoLvl, 1, 4);    break;
               case "katakanaPa":    katakanaPaLvl = MathUtils.clamp(addOn +   katakanaPaLvl, 1, 4);    break;
               case "katakanaPi":    katakanaPiLvl = MathUtils.clamp(addOn +   katakanaPiLvl, 1, 4);    break;
               case "katakanaPu":    katakanaPuLvl = MathUtils.clamp(addOn +   katakanaPuLvl, 1, 4);    break;
               case "katakanaPe":    katakanaPeLvl = MathUtils.clamp(addOn +   katakanaPeLvl, 1, 4);    break;
               case "katakanaPo":    katakanaPoLvl = MathUtils.clamp(addOn +   katakanaPoLvl, 1, 4);    break;
               case "katakanaKya":  katakanaKyaLvl = MathUtils.clamp(addOn +  katakanaKyaLvl, 1, 4);    break;
               case "katakanaKyu":  katakanaKyuLvl = MathUtils.clamp(addOn +  katakanaKyuLvl, 1, 4);    break;
               case "katakanaKyo":  katakanaKyoLvl = MathUtils.clamp(addOn +  katakanaKyoLvl, 1, 4);    break;
               case "katakanaSha":  katakanaShaLvl = MathUtils.clamp(addOn +  katakanaShaLvl, 1, 4);    break;
               case "katakanaShu":  katakanaShuLvl = MathUtils.clamp(addOn +  katakanaShuLvl, 1, 4);    break;
               case "katakanaSho":  katakanaShoLvl = MathUtils.clamp(addOn +  katakanaShoLvl, 1, 4);    break;
               case "katakanaCha":  katakanaChaLvl = MathUtils.clamp(addOn +  katakanaChaLvl, 1, 4);    break;
               case "katakanaChu":  katakanaChuLvl = MathUtils.clamp(addOn +  katakanaChuLvl, 1, 4);    break;
               case "katakanaCho":  katakanaChoLvl = MathUtils.clamp(addOn +  katakanaChoLvl, 1, 4);    break;
               case "katakanaHya":  katakanaHyaLvl = MathUtils.clamp(addOn +  katakanaHyaLvl, 1, 4);    break;
               case "katakanaHyu":  katakanaHyuLvl = MathUtils.clamp(addOn +  katakanaHyuLvl, 1, 4);    break;
               case "katakanaHyo":  katakanaHyoLvl = MathUtils.clamp(addOn +  katakanaHyoLvl, 1, 4);    break;
               case "katakanaNya":  katakanaNyaLvl = MathUtils.clamp(addOn +  katakanaNyaLvl, 1, 4);    break;
               case "katakanaNyu":  katakanaNyuLvl = MathUtils.clamp(addOn +  katakanaNyuLvl, 1, 4);    break;
               case "katakanaNyo":  katakanaNyoLvl = MathUtils.clamp(addOn +  katakanaNyoLvl, 1, 4);    break;
               case "katakanaMya":  katakanaMyaLvl = MathUtils.clamp(addOn +  katakanaMyaLvl, 1, 4);    break;
               case "katakanaMyu":  katakanaMyuLvl = MathUtils.clamp(addOn +  katakanaMyuLvl, 1, 4);    break;
               case "katakanaMyo":  katakanaMyoLvl = MathUtils.clamp(addOn +  katakanaMyoLvl, 1, 4);    break;
               case "katakanaRya":  katakanaRyaLvl = MathUtils.clamp(addOn +  katakanaRyaLvl, 1, 4);    break;
               case "katakanaRyu":  katakanaRyuLvl = MathUtils.clamp(addOn +  katakanaRyuLvl, 1, 4);    break;
               case "katakanaRyo":  katakanaRyoLvl = MathUtils.clamp(addOn +  katakanaRyoLvl, 1, 4);    break;
               case "katakanaGya":  katakanaGyaLvl = MathUtils.clamp(addOn +  katakanaGyaLvl, 1, 4);    break;
               case "katakanaGyu":  katakanaGyuLvl = MathUtils.clamp(addOn +  katakanaGyuLvl, 1, 4);    break;
               case "katakanaGyo":  katakanaGyoLvl = MathUtils.clamp(addOn +  katakanaGyoLvl, 1, 4);    break;
               case "katakanaJya":  katakanaJyaLvl = MathUtils.clamp(addOn +  katakanaJyaLvl, 1, 4);    break;
               case "katakanaJyu":  katakanaJyuLvl = MathUtils.clamp(addOn +  katakanaJyuLvl, 1, 4);    break;
               case "katakanaJyo":  katakanaJyoLvl = MathUtils.clamp(addOn +  katakanaJyoLvl, 1, 4);    break;
               case "katakanaDya":  katakanaDyaLvl = MathUtils.clamp(addOn +  katakanaDyaLvl, 1, 4);    break;
               case "katakanaDyu":  katakanaDyuLvl = MathUtils.clamp(addOn +  katakanaDyuLvl, 1, 4);    break;
               case "katakanaDyo":  katakanaDyoLvl = MathUtils.clamp(addOn +  katakanaDyoLvl, 1, 4);    break;
               case "katakanaBya":  katakanaByaLvl = MathUtils.clamp(addOn +  katakanaByaLvl, 1, 4);    break;
               case "katakanaByu":  katakanaByuLvl = MathUtils.clamp(addOn +  katakanaByuLvl, 1, 4);    break;
               case "katakanaByo":  katakanaByoLvl = MathUtils.clamp(addOn +  katakanaByoLvl, 1, 4);    break;
               case "katakanaPya":  katakanaPyaLvl = MathUtils.clamp(addOn +  katakanaPyaLvl, 1, 4);    break;
               case "katakanaPyu":  katakanaPyuLvl = MathUtils.clamp(addOn +  katakanaPyuLvl, 1, 4);    break;
               case "katakanaPyo":  katakanaPyoLvl = MathUtils.clamp(addOn +  katakanaPyoLvl, 1, 4);    break;
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
               default:  Gdx.app.log(TAG, " default "); break;

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
                case "katakanaShi":  katakanaShiLvl = MathUtils.clamp(takeOff -  katakanaShiLvl, 1, 4);    break;
                case "katakanaSu":   katakanaSuLvl = MathUtils.clamp(takeOff -    katakanaSuLvl, 1, 4);    break;
                case "katakanaSe":    katakanaSeLvl = MathUtils.clamp(takeOff -   katakanaSeLvl, 1, 4);    break;
                case "katakanaSo":    katakanaSoLvl = MathUtils.clamp(takeOff -   katakanaSoLvl, 1, 4);    break;
                case "katakanaTa":    katakanaTaLvl = MathUtils.clamp(takeOff -   katakanaTaLvl, 1, 4);    break;
                case "katakanaChi":  katakanaChiLvl = MathUtils.clamp(takeOff -  katakanaChiLvl, 1, 4);    break;
                case "katakanaTsu":  katakanaTsuLvl = MathUtils.clamp(takeOff -  katakanaTsuLvl, 1, 4);    break;
                case "katakanaTe":    katakanaTeLvl = MathUtils.clamp(takeOff -   katakanaTeLvl, 1, 4);    break;
                case "katakanaTo":    katakanaToLvl = MathUtils.clamp(takeOff -   katakanaToLvl, 1, 4);    break;
                case "katakanaNa":    katakanaNaLvl = MathUtils.clamp(takeOff -   katakanaNaLvl, 1, 4);    break;
                case "katakanaNi":    katakanaNiLvl = MathUtils.clamp(takeOff -   katakanaNiLvl, 1, 4);    break;
                case "katakanaNu":    katakanaNuLvl = MathUtils.clamp(takeOff -   katakanaNuLvl, 1, 4);    break;
                case "katakanaNe":    katakanaNeLvl = MathUtils.clamp(takeOff -   katakanaNeLvl, 1, 4);    break;
                case "katakanaNo":    katakanaNoLvl = MathUtils.clamp(takeOff -   katakanaNoLvl, 1, 4);    break;
                case "katakanaHa":    katakanaHaLvl = MathUtils.clamp(takeOff -   katakanaHaLvl, 1, 4);    break;
                case "katakanaHi":    katakanaHiLvl = MathUtils.clamp(takeOff -   katakanaHiLvl, 1, 4);    break;
                case "katakanaHu":    katakanaHuLvl = MathUtils.clamp(takeOff -   katakanaHuLvl, 1, 4);    break;
                case "katakanaHe":    katakanaHeLvl = MathUtils.clamp(takeOff -   katakanaHeLvl, 1, 4);    break;
                case "katakanaHo":    katakanaHoLvl = MathUtils.clamp(takeOff -   katakanaHoLvl, 1, 4);    break;
                case "katakanaMa":    katakanaMaLvl = MathUtils.clamp(takeOff -   katakanaMaLvl, 1, 4);    break;
                case "katakanaMi":    katakanaMiLvl = MathUtils.clamp(takeOff -   katakanaMiLvl, 1, 4);    break;
                case "katakanaMu":    katakanaMuLvl = MathUtils.clamp(takeOff -   katakanaMuLvl, 1, 4);    break;
                case "katakanaMe":    katakanaMeLvl = MathUtils.clamp(takeOff -   katakanaMeLvl, 1, 4);    break;
                case "katakanaMo":    katakanaMoLvl = MathUtils.clamp(takeOff -   katakanaMoLvl, 1, 4);    break;
                case "katakanaRa":    katakanaRaLvl = MathUtils.clamp(takeOff -   katakanaRaLvl, 1, 4);    break;
                case "katakanaRi":    katakanaRiLvl = MathUtils.clamp(takeOff -   katakanaRiLvl, 1, 4);    break;
                case "katakanaRu":    katakanaRuLvl = MathUtils.clamp(takeOff -   katakanaRuLvl, 1, 4);    break;
                case "katakanaRe":    katakanaReLvl = MathUtils.clamp(takeOff -   katakanaReLvl, 1, 4);    break;
                case "katakanaRo":    katakanaRoLvl = MathUtils.clamp(takeOff -   katakanaRoLvl, 1, 4);    break;
                case "katakanaYa":    katakanaYaLvl = MathUtils.clamp(takeOff -   katakanaYaLvl, 1, 4);    break;
                case "katakanaYu":    katakanaYuLvl = MathUtils.clamp(takeOff -   katakanaYuLvl, 1, 4);    break;
                case "katakanaYo":    katakanaYoLvl = MathUtils.clamp(takeOff -   katakanaYoLvl, 1, 4);    break;
                case "katakanaWa":    katakanaWaLvl = MathUtils.clamp(takeOff -   katakanaWaLvl, 1, 4);    break;
                case "katakanaWo":    katakanaWoLvl = MathUtils.clamp(takeOff -   katakanaWoLvl, 1, 4);    break;
                case "katakanaN":      katakanaNLvl = MathUtils.clamp(takeOff -    katakanaNLvl, 1, 4);    break;
                case "katakanaGa":    katakanaGaLvl = MathUtils.clamp(takeOff -   katakanaGaLvl, 1, 4);    break;
                case "katakanaGi":    katakanaGiLvl = MathUtils.clamp(takeOff -   katakanaGiLvl, 1, 4);    break;
                case "katakanaGu":    katakanaGuLvl = MathUtils.clamp(takeOff -   katakanaGuLvl, 1, 4);    break;
                case "katakanaGe":    katakanaGeLvl = MathUtils.clamp(takeOff -   katakanaGeLvl, 1, 4);    break;
                case "katakanaGo":    katakanaGoLvl = MathUtils.clamp(takeOff -   katakanaGoLvl, 1, 4);    break;
                case "katakanaZa":    katakanaZaLvl = MathUtils.clamp(takeOff -   katakanaZaLvl, 1, 4);    break;
                case "katakanaJi":    katakanaJiLvl = MathUtils.clamp(takeOff -   katakanaJiLvl, 1, 4);    break;
                case "katakanaZu":    katakanaZuLvl = MathUtils.clamp(takeOff -   katakanaZuLvl, 1, 4);    break;
                case "katakanaZe":    katakanaZeLvl = MathUtils.clamp(takeOff -   katakanaZeLvl, 1, 4);    break;
                case "katakanaZo":    katakanaZoLvl = MathUtils.clamp(takeOff -   katakanaZoLvl, 1, 4);    break;
                case "katakanaDa":    katakanaDaLvl = MathUtils.clamp(takeOff -   katakanaDaLvl, 1, 4);    break;
                case "katakanaDi":    katakanaDiLvl = MathUtils.clamp(takeOff -   katakanaDiLvl, 1, 4);    break;
                case "katakanaDu":    katakanaDuLvl = MathUtils.clamp(takeOff -   katakanaDuLvl, 1, 4);    break;
                case "katakanaDe":    katakanaDeLvl = MathUtils.clamp(takeOff -   katakanaDeLvl, 1, 4);    break;
                case "katakanaDo":    katakanaDoLvl = MathUtils.clamp(takeOff -   katakanaDoLvl, 1, 4);    break;
                case "katakanaBa":    katakanaBaLvl = MathUtils.clamp(takeOff -   katakanaBaLvl, 1, 4);    break;
                case "katakanaBi":    katakanaBiLvl = MathUtils.clamp(takeOff -   katakanaBiLvl, 1, 4);    break;
                case "katakanaBu":    katakanaBuLvl = MathUtils.clamp(takeOff -   katakanaBuLvl, 1, 4);    break;
                case "katakanaBe":    katakanaBeLvl = MathUtils.clamp(takeOff -   katakanaBeLvl, 1, 4);    break;
                case "katakanaBo":    katakanaBoLvl = MathUtils.clamp(takeOff -   katakanaBoLvl, 1, 4);    break;
                case "katakanaPa":    katakanaPaLvl = MathUtils.clamp(takeOff -   katakanaPaLvl, 1, 4);    break;
                case "katakanaPi":    katakanaPiLvl = MathUtils.clamp(takeOff -   katakanaPiLvl, 1, 4);    break;
                case "katakanaPu":    katakanaPuLvl = MathUtils.clamp(takeOff -   katakanaPuLvl, 1, 4);    break;
                case "katakanaPe":    katakanaPeLvl = MathUtils.clamp(takeOff -   katakanaPeLvl, 1, 4);    break;
                case "katakanaPo":    katakanaPoLvl = MathUtils.clamp(takeOff -   katakanaPoLvl, 1, 4);    break;
                case "katakanaKya":  katakanaKyaLvl = MathUtils.clamp(takeOff -  katakanaKyaLvl, 1, 4);    break;
                case "katakanaKyu":  katakanaKyuLvl = MathUtils.clamp(takeOff -  katakanaKyuLvl, 1, 4);    break;
                case "katakanaKyo":  katakanaKyoLvl = MathUtils.clamp(takeOff -  katakanaKyoLvl, 1, 4);    break;
                case "katakanaSha":  katakanaShaLvl = MathUtils.clamp(takeOff -  katakanaShaLvl, 1, 4);    break;
                case "katakanaShu":  katakanaShuLvl = MathUtils.clamp(takeOff -  katakanaShuLvl, 1, 4);    break;
                case "katakanaSho":  katakanaShoLvl = MathUtils.clamp(takeOff -  katakanaShoLvl, 1, 4);    break;
                case "katakanaCha":  katakanaChaLvl = MathUtils.clamp(takeOff -  katakanaChaLvl, 1, 4);    break;
                case "katakanaChu":  katakanaChuLvl = MathUtils.clamp(takeOff -  katakanaChuLvl, 1, 4);    break;
                case "katakanaCho":  katakanaChoLvl = MathUtils.clamp(takeOff -  katakanaChoLvl, 1, 4);    break;
                case "katakanaHya":  katakanaHyaLvl = MathUtils.clamp(takeOff -  katakanaHyaLvl, 1, 4);    break;
                case "katakanaHyu":  katakanaHyuLvl = MathUtils.clamp(takeOff -  katakanaHyuLvl, 1, 4);    break;
                case "katakanaHyo":  katakanaHyoLvl = MathUtils.clamp(takeOff -  katakanaHyoLvl, 1, 4);    break;
                case "katakanaNya":  katakanaNyaLvl = MathUtils.clamp(takeOff -  katakanaNyaLvl, 1, 4);    break;
                case "katakanaNyu":  katakanaNyuLvl = MathUtils.clamp(takeOff -  katakanaNyuLvl, 1, 4);    break;
                case "katakanaNyo":  katakanaNyoLvl = MathUtils.clamp(takeOff -  katakanaNyoLvl, 1, 4);    break;
                case "katakanaMya":  katakanaMyaLvl = MathUtils.clamp(takeOff -  katakanaMyaLvl, 1, 4);    break;
                case "katakanaMyu":  katakanaMyuLvl = MathUtils.clamp(takeOff -  katakanaMyuLvl, 1, 4);    break;
                case "katakanaMyo":  katakanaMyoLvl = MathUtils.clamp(takeOff -  katakanaMyoLvl, 1, 4);    break;
                case "katakanaRya":  katakanaRyaLvl = MathUtils.clamp(takeOff -  katakanaRyaLvl, 1, 4);    break;
                case "katakanaRyu":  katakanaRyuLvl = MathUtils.clamp(takeOff -  katakanaRyuLvl, 1, 4);    break;
                case "katakanaRyo":  katakanaRyoLvl = MathUtils.clamp(takeOff -  katakanaRyoLvl, 1, 4);    break;
                case "katakanaGya":  katakanaGyaLvl = MathUtils.clamp(takeOff -  katakanaGyaLvl, 1, 4);    break;
                case "katakanaGyu":  katakanaGyuLvl = MathUtils.clamp(takeOff -  katakanaGyuLvl, 1, 4);    break;
                case "katakanaGyo":  katakanaGyoLvl = MathUtils.clamp(takeOff -  katakanaGyoLvl, 1, 4);    break;
                case "katakanaJya":  katakanaJyaLvl = MathUtils.clamp(takeOff -  katakanaJyaLvl, 1, 4);    break;
                case "katakanaJyu":  katakanaJyuLvl = MathUtils.clamp(takeOff -  katakanaJyuLvl, 1, 4);    break;
                case "katakanaJyo":  katakanaJyoLvl = MathUtils.clamp(takeOff -  katakanaJyoLvl, 1, 4);    break;
                case "katakanaDya":  katakanaDyaLvl = MathUtils.clamp(takeOff -  katakanaDyaLvl, 1, 4);    break;
                case "katakanaDyu":  katakanaDyuLvl = MathUtils.clamp(takeOff -  katakanaDyuLvl, 1, 4);    break;
                case "katakanaDyo":  katakanaDyoLvl = MathUtils.clamp(takeOff -  katakanaDyoLvl, 1, 4);    break;
                case "katakanaBya":  katakanaByaLvl = MathUtils.clamp(takeOff -  katakanaByaLvl, 1, 4);    break;
                case "katakanaByu":  katakanaByuLvl = MathUtils.clamp(takeOff -  katakanaByuLvl, 1, 4);    break;
                case "katakanaByo":  katakanaByoLvl = MathUtils.clamp(takeOff -  katakanaByoLvl, 1, 4);    break;
                case "katakanaPya":  katakanaPyaLvl = MathUtils.clamp(takeOff -  katakanaPyaLvl, 1, 4);    break;
                case "katakanaPyu":  katakanaPyuLvl = MathUtils.clamp(takeOff -  katakanaPyuLvl, 1, 4);    break;
                case "katakanaPyo":  katakanaPyoLvl = MathUtils.clamp(takeOff -  katakanaPyoLvl, 1, 4);    break;
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

     public static void adjustLvl(String letter, int newLvl){
          switch (letter){
               case "hiraganaA":         hiraganaALvl = newLvl;    break;
               case "hiraganaI":         hiraganaILvl = newLvl;    break;
               case "hiraganaU":         hiraganaULvl = newLvl;    break;
               case "hiraganaE":         hiraganaELvl = newLvl;    break;
               case "hiraganaO":         hiraganaOLvl = newLvl;    break;
               case "hiraganaKa":       hiraganaKaLvl = newLvl;    break;
               case "hiraganaKi":       hiraganaKiLvl = newLvl;    break;
               case "hiraganaKu":       hiraganaKuLvl = newLvl;    break;
               case "hiraganaKe":       hiraganaKeLvl = newLvl;    break;
               case "hiraganaKo":       hiraganaKoLvl = newLvl;    break;
               case "hiraganaSa":       hiraganaSaLvl = newLvl;    break;
               case "hiraganaShi":     hiraganaShiLvl = newLvl;    break;
               case "hiraganaSu":       hiraganaSuLvl = newLvl;    break;
               case "hiraganaSe":       hiraganaSeLvl = newLvl;    break;
               case "hiraganaSo":       hiraganaSoLvl = newLvl;    break;
               case "hiraganaTa":       hiraganaTaLvl = newLvl;    break;
               case "hiraganaChi":     hiraganaChiLvl = newLvl;    break;
               case "hiraganaTsu":     hiraganaTsuLvl = newLvl;    break;
               case "hiraganaTe":       hiraganaTeLvl = newLvl;    break;
               case "hiraganaTo":       hiraganaToLvl = newLvl;    break;
               case "hiraganaNa":       hiraganaNaLvl = newLvl;    break;
               case "hiraganaNi":       hiraganaNiLvl = newLvl;    break;
               case "hiraganaNu":       hiraganaNuLvl = newLvl;    break;
               case "hiraganaNe":       hiraganaNeLvl = newLvl;    break;
               case "hiraganaNo":       hiraganaNoLvl = newLvl;    break;
               case "hiraganaHa":       hiraganaHaLvl = newLvl;    break;
               case "hiraganaHi":       hiraganaHiLvl = newLvl;    break;
               case "hiraganaHu":       hiraganaHuLvl = newLvl;    break;
               case "hiraganaHe":       hiraganaHeLvl = newLvl;    break;
               case "hiraganaHo":       hiraganaHoLvl = newLvl;    break;
               case "hiraganaMa":       hiraganaMaLvl = newLvl;    break;
               case "hiraganaMi":       hiraganaMiLvl = newLvl;    break;
               case "hiraganaMu":       hiraganaMuLvl = newLvl;    break;
               case "hiraganaMe":       hiraganaMeLvl = newLvl;    break;
               case "hiraganaMo":       hiraganaMoLvl = newLvl;    break;
               case "hiraganaRa":       hiraganaRaLvl = newLvl;    break;
               case "hiraganaRi":       hiraganaRiLvl = newLvl;    break;
               case "hiraganaRu":       hiraganaRuLvl = newLvl;    break;
               case "hiraganaRe":       hiraganaReLvl = newLvl;    break;
               case "hiraganaRo":       hiraganaRoLvl = newLvl;    break;
               case "hiraganaYa":       hiraganaYaLvl = newLvl;    break;
               case "hiraganaYu":       hiraganaYuLvl = newLvl;    break;
               case "hiraganaYo":       hiraganaYoLvl = newLvl;    break;
               case "hiraganaWa":       hiraganaWaLvl = newLvl;    break;
               case "hiraganaWo":       hiraganaWoLvl = newLvl;    break;
               case "hiraganaN":         hiraganaNLvl = newLvl;    break;
               case "hiraganaGa":       hiraganaGaLvl = newLvl;    break;
               case "hiraganaGi":       hiraganaGiLvl = newLvl;    break;
               case "hiraganaGu":       hiraganaGuLvl = newLvl;    break;
               case "hiraganaGe":       hiraganaGeLvl = newLvl;    break;
               case "hiraganaGo":       hiraganaGoLvl = newLvl;    break;
               case "hiraganaZa":       hiraganaZaLvl = newLvl;    break;
               case "hiraganaJi":       hiraganaJiLvl = newLvl;    break;
               case "hiraganaZu":       hiraganaZuLvl = newLvl;    break;
               case "hiraganaZe":       hiraganaZeLvl = newLvl;    break;
               case "hiraganaZo":       hiraganaZoLvl = newLvl;    break;
               case "hiraganaDa":       hiraganaDaLvl = newLvl;    break;
               case "hiraganaDi":       hiraganaDiLvl = newLvl;    break;
               case "hiraganaDu":       hiraganaDuLvl = newLvl;    break;
               case "hiraganaDe":       hiraganaDeLvl = newLvl;    break;
               case "hiraganaDo":       hiraganaDoLvl = newLvl;    break;
               case "hiraganaBa":       hiraganaBaLvl = newLvl;    break;
               case "hiraganaBi":       hiraganaBiLvl = newLvl;    break;
               case "hiraganaBu":       hiraganaBuLvl = newLvl;    break;
               case "hiraganaBe":       hiraganaBeLvl = newLvl;    break;
               case "hiraganaBo":       hiraganaBoLvl = newLvl;    break;
               case "hiraganaPa":       hiraganaPaLvl = newLvl;    break;
               case "hiraganaPi":       hiraganaPiLvl = newLvl;    break;
               case "hiraganaPu":       hiraganaPuLvl = newLvl;    break;
               case "hiraganaPe":       hiraganaPeLvl = newLvl;    break;
               case "hiraganaPo":       hiraganaPoLvl = newLvl;    break;
               case "hiraganaKya":     hiraganaKyaLvl = newLvl;    break;
               case "hiraganaKyu":     hiraganaKyuLvl = newLvl;    break;
               case "hiraganaKyo":     hiraganaKyoLvl = newLvl;    break;
               case "hiraganaSha":     hiraganaShaLvl = newLvl;    break;
               case "hiraganaShu":     hiraganaShuLvl = newLvl;    break;
               case "hiraganaSho":     hiraganaShoLvl = newLvl;    break;
               case "hiraganaCha":     hiraganaChaLvl = newLvl;    break;
               case "hiraganaChu":     hiraganaChuLvl = newLvl;    break;
               case "hiraganaCho":     hiraganaChoLvl = newLvl;    break;
               case "hiraganaHya":     hiraganaHyaLvl = newLvl;    break;
               case "hiraganaHyu":     hiraganaHyuLvl = newLvl;    break;
               case "hiraganaHyo":     hiraganaHyoLvl = newLvl;    break;
               case "hiraganaNya":     hiraganaNyaLvl = newLvl;    break;
               case "hiraganaNyu":     hiraganaNyuLvl = newLvl;    break;
               case "hiraganaNyo":     hiraganaNyoLvl = newLvl;    break;
               case "hiraganaMya":     hiraganaMyaLvl = newLvl;    break;
               case "hiraganaMyu":     hiraganaMyuLvl = newLvl;    break;
               case "hiraganaMyo":     hiraganaMyoLvl = newLvl;    break;
               case "hiraganaRya":     hiraganaRyaLvl = newLvl;    break;
               case "hiraganaRyu":     hiraganaRyuLvl = newLvl;    break;
               case "hiraganaRyo":     hiraganaRyoLvl = newLvl;    break;
               case "hiraganaGya":     hiraganaGyaLvl = newLvl;    break;
               case "hiraganaGyu":     hiraganaGyuLvl = newLvl;    break;
               case "hiraganaGyo":     hiraganaGyoLvl = newLvl;    break;
               case "hiraganaJya":     hiraganaJyaLvl = newLvl;    break;
               case "hiraganaJyu":     hiraganaJyuLvl = newLvl;    break;
               case "hiraganaJyo":     hiraganaJyoLvl = newLvl;    break;
               case "hiraganaDya":     hiraganaDyaLvl = newLvl;    break;
               case "hiraganaDyu":     hiraganaDyuLvl = newLvl;    break;
               case "hiraganaDyo":     hiraganaDyoLvl = newLvl;    break;
               case "hiraganaBya":     hiraganaByaLvl = newLvl;    break;
               case "hiraganaByu":     hiraganaByuLvl = newLvl;    break;
               case "hiraganaByo":     hiraganaByoLvl = newLvl;    break;
               case "hiraganaPya":     hiraganaPyaLvl = newLvl;    break;
               case "hiraganaPyu":     hiraganaPyuLvl = newLvl;    break;
               case "hiraganaPyo":     hiraganaPyoLvl = newLvl;    break;
               case "katakanaA":         katakanaALvl = newLvl;    break;
               case "katakanaI":         katakanaILvl = newLvl;    break;
               case "katakanaU":         katakanaULvl = newLvl;    break;
               case "katakanaE":         katakanaELvl = newLvl;    break;
               case "katakanaO":         katakanaOLvl = newLvl;    break;
               case "katakanaKa":       katakanaKaLvl = newLvl;    break;
               case "katakanaKi":       katakanaKiLvl = newLvl;    break;
               case "katakanaKu":       katakanaKuLvl = newLvl;    break;
               case "katakanaKe":       katakanaKeLvl = newLvl;    break;
               case "katakanaKo":       katakanaKoLvl = newLvl;    break;
               case "katakanaSa":       katakanaSaLvl = newLvl;    break;
               case "katakanaShi":  katakanaShiLvl = newLvl;    break;
               case "katakanaSu":   katakanaSuLvl  = newLvl;    break;
               case "katakanaSe":    katakanaSeLvl = newLvl;    break;
               case "katakanaSo":    katakanaSoLvl = newLvl;    break;
               case "katakanaTa":    katakanaTaLvl = newLvl;    break;
               case "katakanaChi":  katakanaChiLvl = newLvl;    break;
               case "katakanaTsu":  katakanaTsuLvl = newLvl;    break;
               case "katakanaTe":    katakanaTeLvl = newLvl;    break;
               case "katakanaTo":    katakanaToLvl = newLvl;    break;
               case "katakanaNa":    katakanaNaLvl = newLvl;    break;
               case "katakanaNi":    katakanaNiLvl = newLvl;    break;
               case "katakanaNu":    katakanaNuLvl = newLvl;    break;
               case "katakanaNe":    katakanaNeLvl = newLvl;    break;
               case "katakanaNo":    katakanaNoLvl = newLvl;    break;
               case "katakanaHa":    katakanaHaLvl = newLvl;    break;
               case "katakanaHi":    katakanaHiLvl = newLvl;    break;
               case "katakanaHu":    katakanaHuLvl = newLvl;    break;
               case "katakanaHe":    katakanaHeLvl = newLvl;    break;
               case "katakanaHo":    katakanaHoLvl = newLvl;    break;
               case "katakanaMa":    katakanaMaLvl = newLvl;    break;
               case "katakanaMi":    katakanaMiLvl = newLvl;    break;
               case "katakanaMu":    katakanaMuLvl = newLvl;    break;
               case "katakanaMe":    katakanaMeLvl = newLvl;    break;
               case "katakanaMo":    katakanaMoLvl = newLvl;    break;
               case "katakanaRa":    katakanaRaLvl = newLvl;    break;
               case "katakanaRi":    katakanaRiLvl = newLvl;    break;
               case "katakanaRu":    katakanaRuLvl = newLvl;    break;
               case "katakanaRe":    katakanaReLvl = newLvl;    break;
               case "katakanaRo":    katakanaRoLvl = newLvl;    break;
               case "katakanaYa":    katakanaYaLvl = newLvl;    break;
               case "katakanaYu":    katakanaYuLvl = newLvl;    break;
               case "katakanaYo":    katakanaYoLvl = newLvl;    break;
               case "katakanaWa":    katakanaWaLvl = newLvl;    break;
               case "katakanaWo":    katakanaWoLvl = newLvl;    break;
               case "katakanaN":      katakanaNLvl = newLvl;    break;
               case "katakanaGa":    katakanaGaLvl = newLvl;    break;
               case "katakanaGi":    katakanaGiLvl = newLvl;    break;
               case "katakanaGu":    katakanaGuLvl = newLvl;    break;
               case "katakanaGe":    katakanaGeLvl = newLvl;    break;
               case "katakanaGo":    katakanaGoLvl = newLvl;    break;
               case "katakanaZa":    katakanaZaLvl = newLvl;    break;
               case "katakanaJi":    katakanaJiLvl = newLvl;    break;
               case "katakanaZu":    katakanaZuLvl = newLvl;    break;
               case "katakanaZe":    katakanaZeLvl = newLvl;    break;
               case "katakanaZo":    katakanaZoLvl = newLvl;    break;
               case "katakanaDa":    katakanaDaLvl = newLvl;    break;
               case "katakanaDi":    katakanaDiLvl = newLvl;    break;
               case "katakanaDu":    katakanaDuLvl = newLvl;    break;
               case "katakanaDe":    katakanaDeLvl = newLvl;    break;
               case "katakanaDo":    katakanaDoLvl = newLvl;    break;
               case "katakanaBa":    katakanaBaLvl = newLvl;    break;
               case "katakanaBi":    katakanaBiLvl = newLvl;    break;
               case "katakanaBu":    katakanaBuLvl = newLvl;    break;
               case "katakanaBe":    katakanaBeLvl = newLvl;    break;
               case "katakanaBo":    katakanaBoLvl = newLvl;    break;
               case "katakanaPa":    katakanaPaLvl = newLvl;    break;
               case "katakanaPi":    katakanaPiLvl = newLvl;    break;
               case "katakanaPu":    katakanaPuLvl = newLvl;    break;
               case "katakanaPe":    katakanaPeLvl = newLvl;    break;
               case "katakanaPo":    katakanaPoLvl = newLvl;    break;
               case "katakanaKya":  katakanaKyaLvl = newLvl;    break;
               case "katakanaKyu":  katakanaKyuLvl = newLvl;    break;
               case "katakanaKyo":  katakanaKyoLvl = newLvl;    break;
               case "katakanaSha":  katakanaShaLvl = newLvl;    break;
               case "katakanaShu":  katakanaShuLvl = newLvl;    break;
               case "katakanaSho":  katakanaShoLvl = newLvl;    break;
               case "katakanaCha":  katakanaChaLvl = newLvl;    break;
               case "katakanaChu":  katakanaChuLvl = newLvl;    break;
               case "katakanaCho":  katakanaChoLvl = newLvl;    break;
               case "katakanaHya":  katakanaHyaLvl = newLvl;    break;
               case "katakanaHyu":  katakanaHyuLvl = newLvl;    break;
               case "katakanaHyo":  katakanaHyoLvl = newLvl;    break;
               case "katakanaNya":  katakanaNyaLvl = newLvl;    break;
               case "katakanaNyu":  katakanaNyuLvl = newLvl;    break;
               case "katakanaNyo":  katakanaNyoLvl = newLvl;    break;
               case "katakanaMya":  katakanaMyaLvl = newLvl;    break;
               case "katakanaMyu":  katakanaMyuLvl = newLvl;    break;
               case "katakanaMyo":  katakanaMyoLvl = newLvl;    break;
               case "katakanaRya":  katakanaRyaLvl = newLvl;    break;
               case "katakanaRyu":  katakanaRyuLvl = newLvl;    break;
               case "katakanaRyo":  katakanaRyoLvl = newLvl;    break;
               case "katakanaGya":  katakanaGyaLvl = newLvl;    break;
               case "katakanaGyu":  katakanaGyuLvl = newLvl;    break;
               case "katakanaGyo":  katakanaGyoLvl = newLvl;    break;
               case "katakanaJya":  katakanaJyaLvl = newLvl;    break;
               case "katakanaJyu":  katakanaJyuLvl = newLvl;    break;
               case "katakanaJyo":  katakanaJyoLvl = newLvl;    break;
               case "katakanaDya":  katakanaDyaLvl = newLvl;    break;
               case "katakanaDyu":  katakanaDyuLvl = newLvl;    break;
               case "katakanaDyo":  katakanaDyoLvl = newLvl;    break;
               case "katakanaBya":  katakanaByaLvl = newLvl;    break;
               case "katakanaByu":  katakanaByuLvl = newLvl;    break;
               case "katakanaByo":  katakanaByoLvl = newLvl;    break;
               case "katakanaPya":  katakanaPyaLvl = newLvl;    break;
               case "katakanaPyu":  katakanaPyuLvl = newLvl;    break;
               case "katakanaPyo":  katakanaPyoLvl = newLvl;    break;
               case "kanjiHa":          kanjiHaLvl = newLvl; break;
               case "kanjiHana":          kanjiKiLvl = newLvl; break;
               case "kanjiKi":    kanjiMushiLvl = newLvl; break;
               case "kanjiMori":      kanjiKazeLvl = newLvl; break;
               case "kanjiMushi":      kanjiKazeLvl = newLvl; break;
               case "kanjiIshi":      kanjiUchiLvl = newLvl; break;
               case "kanjiKaze":        kanjiUmiLvl = newLvl; break;
               case "kanjiTsuchi":      kanjiMizuLvl = newLvl; break;
               case "kanjiUchi":        kanjiIkeLvl = newLvl; break;
               case "kanjiYama":    kanjiKooriLvl = newLvl; break;
               case "kanjiUmi":  kanjiHayashiLvl = newLvl; break;
               case "kanjiSakana":          kanjiToLvl = newLvl; break;
               case "kanjiMizu":      kanjiTeraLvl = newLvl; break;
               case "kanjiKai":      kanjiSotoLvl = newLvl; break;
               case "kanjiIke":          kanjiHiLvl = newLvl; break;
               case "kanjiYuki":        kanjiAkaLvl = newLvl; break;
               case "kanjiKoori":      kanjiHanaLvl = newLvl; break;
               case "kanjiKawa":      kanjiMoriLvl = newLvl; break;
               case "kanjiHayashi":      kanjiIshiLvl = newLvl; break;
               case "kanjiFuyu":    kanjiTsuchiLvl = newLvl;  break;
               case "kanjiTo":      kanjiYamaLvl = newLvl; break;
               case "kanjiMon":  kanjiSakanaLvl = newLvl; break;
               case "kanjiTera":        kanjiKaiLvl = newLvl; break;
               case "kanjiAna":      kanjiYukiLvl = newLvl; break;
               case "kanjiSoto":      kanjiKawaLvl = newLvl; break;
               case "kanjiKa":      kanjiFuyuLvl = newLvl; break;
               case "kanjiHi":        kanjiMonLvl = newLvl; break;
               case "kanjiChi":        kanjiAnaLvl = newLvl; break;
               case "kanjiAka":          kanjiKaLvl = newLvl; break;
               case "kanjiHikari":        kanjiChiLvl = newLvl; break;
               default: break;

          }
     }
}
