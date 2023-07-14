package com.mygdx.game.japanese;


import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by firasAltayeb on 07/04/2017.
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
         katakanaByoLvl = 1,    katakanaPyoLvl = 1;


     private static boolean allHiraganaMemorised = false;
     private static boolean allKatakanaMemorised = false;
     private static Hashtable<String, Integer> hiraganaLvlTable;
     private static Hashtable<String, Integer> katakanaLvlTable;


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

     public static void increaseLvl(String letter){
          switch (letter){
               case "hiraganaA":       hiraganaALvl++;    break;
               case "hiraganaI":       hiraganaILvl++;    break;
               case "hiraganaU":       hiraganaULvl++;    break;
               case "hiraganaE":       hiraganaELvl++;    break;
               case "hiraganaO":       hiraganaOLvl++;    break;
               case "hiraganaKa":      hiraganaKaLvl++;     break;
               case "hiraganaKi":      hiraganaKiLvl++;     break;
               case "hiraganaKu":      hiraganaKuLvl++;     break;
               case "hiraganaKe":      hiraganaKeLvl++;     break;
               case "hiraganaKo":      hiraganaKoLvl++;     break;
               case "hiraganaSa":      hiraganaSaLvl++;     break;
               case "hiraganaShi":     hiraganaShiLvl++;    break;
               case "hiraganaSu":      hiraganaSuLvl++;     break;
               case "hiraganaSe":      hiraganaSeLvl++;     break;
               case "hiraganaSo":      hiraganaSoLvl++;     break;
               case "hiraganaTa":      hiraganaTaLvl++;     break;
               case "hiraganaChi":     hiraganaChiLvl++;    break;
               case "hiraganaTsu":     hiraganaTsuLvl++;    break;
               case "hiraganaTe":      hiraganaTeLvl++;     break;
               case "hiraganaTo":      hiraganaToLvl++;     break;
               case "hiraganaNa":      hiraganaNaLvl++;     break;
               case "hiraganaNi":      hiraganaNiLvl++;     break;
               case "hiraganaNu":      hiraganaNuLvl++;     break;
               case "hiraganaNe":      hiraganaNeLvl++;     break;
               case "hiraganaNo":      hiraganaNoLvl++;     break;
               case "hiraganaHa":      hiraganaHaLvl++;     break;
               case "hiraganaHi":      hiraganaHiLvl++;     break;
               case "hiraganaHu":      hiraganaHuLvl++;     break;
               case "hiraganaHe":      hiraganaHeLvl++;     break;
               case "hiraganaHo":      hiraganaHoLvl++;     break;
               case "hiraganaMa":      hiraganaMaLvl++;     break;
               case "hiraganaMi":      hiraganaMiLvl++;     break;
               case "hiraganaMu":      hiraganaMuLvl++;     break;
               case "hiraganaMe":      hiraganaMeLvl++;     break;
               case "hiraganaMo":      hiraganaMoLvl++;     break;
               case "hiraganaRa":      hiraganaRaLvl++;     break;
               case "hiraganaRi":      hiraganaRiLvl++;     break;
               case "hiraganaRu":      hiraganaRuLvl++;     break;
               case "hiraganaRe":      hiraganaReLvl++;     break;
               case "hiraganaRo":      hiraganaRoLvl++;     break;
               case "hiraganaYa":      hiraganaYaLvl++;     break;
               case "hiraganaYu":      hiraganaYuLvl++;     break;
               case "hiraganaYo":      hiraganaYoLvl++;     break;
               case "hiraganaWa":      hiraganaWaLvl++;     break;
               case "hiraganaWo":      hiraganaWoLvl++;     break;
               case "hiraganaN":       hiraganaNLvl++;      break;
               case "hiraganaGa":      hiraganaGaLvl++;     break;
               case "hiraganaGi":      hiraganaGiLvl++;     break;
               case "hiraganaGu":      hiraganaGuLvl++;     break;
               case "hiraganaGe":      hiraganaGeLvl++;     break;
               case "hiraganaGo":      hiraganaGoLvl++;     break;
               case "hiraganaZa":      hiraganaZaLvl++;     break;
               case "hiraganaJi":      hiraganaJiLvl++;     break;
               case "hiraganaZu":      hiraganaZuLvl++;     break;
               case "hiraganaZe":      hiraganaZeLvl++;     break;
               case "hiraganaZo":      hiraganaZoLvl++;     break;
               case "hiraganaDa":      hiraganaDaLvl++;     break;
               case "hiraganaDi":      hiraganaDiLvl++;     break;
               case "hiraganaDu":      hiraganaDuLvl++;     break;
               case "hiraganaDe":      hiraganaDeLvl++;     break;
               case "hiraganaDo":      hiraganaDoLvl++;     break;
               case "hiraganaBa":      hiraganaBaLvl++;     break;
               case "hiraganaBi":      hiraganaBiLvl++;     break;
               case "hiraganaBu":      hiraganaBuLvl++;     break;
               case "hiraganaBe":      hiraganaBeLvl++;     break;
               case "hiraganaBo":      hiraganaBoLvl++;     break;
               case "hiraganaPa":      hiraganaPaLvl++;     break;
               case "hiraganaPi":      hiraganaPiLvl++;     break;
               case "hiraganaPu":      hiraganaPuLvl++;     break;
               case "hiraganaPe":      hiraganaPeLvl++;     break;
               case "hiraganaPo":      hiraganaPoLvl++;     break;
               case "hiraganaKya":     hiraganaKyaLvl++;     break;
               case "hiraganaKyu":     hiraganaKyuLvl++;     break;
               case "hiraganaKyo":     hiraganaKyoLvl++;     break;
               case "hiraganaSha":     hiraganaShaLvl++;     break;
               case "hiraganaShu":     hiraganaShuLvl++;     break;
               case "hiraganaSho":     hiraganaShoLvl++;     break;
               case "hiraganaCha":     hiraganaChaLvl++;     break;
               case "hiraganaChu":     hiraganaChuLvl++;     break;
               case "hiraganaCho":     hiraganaChoLvl++;     break;
               case "hiraganaHya":     hiraganaHyaLvl++;     break;
               case "hiraganaHyu":     hiraganaHyuLvl++;     break;
               case "hiraganaHyo":     hiraganaHyoLvl++;     break;
               case "hiraganaNya":     hiraganaNyaLvl++;     break;
               case "hiraganaNyu":     hiraganaNyuLvl++;     break;
               case "hiraganaNyo":     hiraganaNyoLvl++;     break;
               case "hiraganaMya":     hiraganaMyaLvl++;     break;
               case "hiraganaMyu":     hiraganaMyuLvl++;     break;
               case "hiraganaMyo":     hiraganaMyoLvl++;     break;
               case "hiraganaRya":     hiraganaRyaLvl++;     break;
               case "hiraganaRyu":     hiraganaRyuLvl++;     break;
               case "hiraganaRyo":     hiraganaRyoLvl++;     break;
               case "hiraganaGya":     hiraganaGyaLvl++;     break;
               case "hiraganaGyu":     hiraganaGyuLvl++;     break;
               case "hiraganaGyo":     hiraganaGyoLvl++;     break;
               case "hiraganaJya":     hiraganaJyaLvl++;     break;
               case "hiraganaJyu":     hiraganaJyuLvl++;     break;
               case "hiraganaJyo":     hiraganaJyoLvl++;     break;
               case "hiraganaDya":     hiraganaDyaLvl++;     break;
               case "hiraganaDyu":     hiraganaDyuLvl++;     break;
               case "hiraganaDyo":     hiraganaDyoLvl++;     break;
               case "hiraganaBya":     hiraganaByaLvl++;     break;
               case "hiraganaByu":     hiraganaByuLvl++;     break;
               case "hiraganaByo":     hiraganaByoLvl++;     break;
               case "hiraganaPya":     hiraganaPyaLvl++;     break;
               case "hiraganaPyu":     hiraganaPyuLvl++;     break;
               case "hiraganaPyo":     hiraganaPyoLvl++;     break;
               case "katakanaA":       katakanaALvl++;    break;
               case "katakanaI":       katakanaILvl++;    break;
               case "katakanaU":       katakanaULvl++;    break;
               case "katakanaE":       katakanaELvl++;    break;
               case "katakanaO":       katakanaOLvl++;    break;
               case "katakanaKa":      katakanaKaLvl++;     break;
               case "katakanaKi":      katakanaKiLvl++;     break;
               case "katakanaKu":      katakanaKuLvl++;     break;
               case "katakanaKe":      katakanaKeLvl++;     break;
               case "katakanaKo":      katakanaKoLvl++;     break;
               case "katakanaSa":      katakanaSaLvl++;     break;
               case "katakanaShi":     katakanaShiLvl++;    break;
               case "katakanaSu":      katakanaSuLvl++;     break;
               case "katakanaSe":      katakanaSeLvl++;     break;
               case "katakanaSo":      katakanaSoLvl++;     break;
               case "katakanaTa":      katakanaTaLvl++;     break;
               case "katakanaChi":     katakanaChiLvl++;    break;
               case "katakanaTsu":     katakanaTsuLvl++;    break;
               case "katakanaTe":      katakanaTeLvl++;     break;
               case "katakanaTo":      katakanaToLvl++;     break;
               case "katakanaNa":      katakanaNaLvl++;     break;
               case "katakanaNi":      katakanaNiLvl++;     break;
               case "katakanaNu":      katakanaNuLvl++;     break;
               case "katakanaNe":      katakanaNeLvl++;     break;
               case "katakanaNo":      katakanaNoLvl++;     break;
               case "katakanaHa":      katakanaHaLvl++;     break;
               case "katakanaHi":      katakanaHiLvl++;     break;
               case "katakanaHu":      katakanaHuLvl++;     break;
               case "katakanaHe":      katakanaHeLvl++;     break;
               case "katakanaHo":      katakanaHoLvl++;     break;
               case "katakanaMa":      katakanaMaLvl++;     break;
               case "katakanaMi":      katakanaMiLvl++;     break;
               case "katakanaMu":      katakanaMuLvl++;     break;
               case "katakanaMe":      katakanaMeLvl++;     break;
               case "katakanaMo":      katakanaMoLvl++;     break;
               case "katakanaRa":      katakanaRaLvl++;     break;
               case "katakanaRi":      katakanaRiLvl++;     break;
               case "katakanaRu":      katakanaRuLvl++;     break;
               case "katakanaRe":      katakanaReLvl++;     break;
               case "katakanaRo":      katakanaRoLvl++;     break;
               case "katakanaYa":      katakanaYaLvl++;     break;
               case "katakanaYu":      katakanaYuLvl++;     break;
               case "katakanaYo":      katakanaYoLvl++;     break;
               case "katakanaWa":      katakanaWaLvl++;     break;
               case "katakanaWo":      katakanaWoLvl++;     break;
               case "katakanaN":       katakanaNLvl++;      break;
               case "katakanaGa":      katakanaGaLvl++;     break;
               case "katakanaGi":      katakanaGiLvl++;     break;
               case "katakanaGu":      katakanaGuLvl++;     break;
               case "katakanaGe":      katakanaGeLvl++;     break;
               case "katakanaGo":      katakanaGoLvl++;     break;
               case "katakanaZa":      katakanaZaLvl++;     break;
               case "katakanaJi":      katakanaJiLvl++;     break;
               case "katakanaZu":      katakanaZuLvl++;     break;
               case "katakanaZe":      katakanaZeLvl++;     break;
               case "katakanaZo":      katakanaZoLvl++;     break;
               case "katakanaDa":      katakanaDaLvl++;     break;
               case "katakanaDi":      katakanaDiLvl++;     break;
               case "katakanaDu":      katakanaDuLvl++;     break;
               case "katakanaDe":      katakanaDeLvl++;     break;
               case "katakanaDo":      katakanaDoLvl++;     break;
               case "katakanaBa":      katakanaBaLvl++;     break;
               case "katakanaBi":      katakanaBiLvl++;     break;
               case "katakanaBu":      katakanaBuLvl++;     break;
               case "katakanaBe":      katakanaBeLvl++;     break;
               case "katakanaBo":      katakanaBoLvl++;     break;
               case "katakanaPa":      katakanaPaLvl++;     break;
               case "katakanaPi":      katakanaPiLvl++;     break;
               case "katakanaPu":      katakanaPuLvl++;     break;
               case "katakanaPe":      katakanaPeLvl++;     break;
               case "katakanaPo":      katakanaPoLvl++;     break;
               case "katakanaKya":     katakanaKyaLvl++;     break;
               case "katakanaKyu":     katakanaKyuLvl++;     break;
               case "katakanaKyo":     katakanaKyoLvl++;     break;
               case "katakanaSha":     katakanaShaLvl++;     break;
               case "katakanaShu":     katakanaShuLvl++;     break;
               case "katakanaSho":     katakanaShoLvl++;     break;
               case "katakanaCha":     katakanaChaLvl++;     break;
               case "katakanaChu":     katakanaChuLvl++;     break;
               case "katakanaCho":     katakanaChoLvl++;     break;
               case "katakanaHya":     katakanaHyaLvl++;     break;
               case "katakanaHyu":     katakanaHyuLvl++;     break;
               case "katakanaHyo":     katakanaHyoLvl++;     break;
               case "katakanaNya":     katakanaNyaLvl++;     break;
               case "katakanaNyu":     katakanaNyuLvl++;     break;
               case "katakanaNyo":     katakanaNyoLvl++;     break;
               case "katakanaMya":     katakanaMyaLvl++;     break;
               case "katakanaMyu":     katakanaMyuLvl++;     break;
               case "katakanaMyo":     katakanaMyoLvl++;     break;
               case "katakanaRya":     katakanaRyaLvl++;     break;
               case "katakanaRyu":     katakanaRyuLvl++;     break;
               case "katakanaRyo":     katakanaRyoLvl++;     break;
               case "katakanaGya":     katakanaGyaLvl++;     break;
               case "katakanaGyu":     katakanaGyuLvl++;     break;
               case "katakanaGyo":     katakanaGyoLvl++;     break;
               case "katakanaJya":     katakanaJyaLvl++;     break;
               case "katakanaJyu":     katakanaJyuLvl++;     break;
               case "katakanaJyo":     katakanaJyoLvl++;     break;
               case "katakanaDya":     katakanaDyaLvl++;     break;
               case "katakanaDyu":     katakanaDyuLvl++;     break;
               case "katakanaDyo":     katakanaDyoLvl++;     break;
               case "katakanaBya":     katakanaByaLvl++;     break;
               case "katakanaByu":     katakanaByuLvl++;     break;
               case "katakanaByo":     katakanaByoLvl++;     break;
               case "katakanaPya":     katakanaPyaLvl++;     break;
               case "katakanaPyu":     katakanaPyuLvl++;     break;
               case "katakanaPyo":     katakanaPyoLvl++;     break;
               default: break;

          }
     }

     public static void decreaseLvl(String letter){
          switch (letter){
               case "hiraganaA":       hiraganaALvl--;    break;
               case "hiraganaI":       hiraganaILvl--;    break;
               case "hiraganaU":       hiraganaULvl--;    break;
               case "hiraganaE":       hiraganaELvl--;    break;
               case "hiraganaO":       hiraganaOLvl--;    break;
               case "hiraganaKa":      hiraganaKaLvl--;     break;
               case "hiraganaKi":      hiraganaKiLvl--;     break;
               case "hiraganaKu":      hiraganaKuLvl--;     break;
               case "hiraganaKe":      hiraganaKeLvl--;     break;
               case "hiraganaKo":      hiraganaKoLvl--;     break;
               case "hiraganaSa":      hiraganaSaLvl--;     break;
               case "hiraganaShi":     hiraganaShiLvl--;    break;
               case "hiraganaSu":      hiraganaSuLvl--;     break;
               case "hiraganaSe":      hiraganaSeLvl--;     break;
               case "hiraganaSo":      hiraganaSoLvl--;     break;
               case "hiraganaTa":      hiraganaTaLvl--;     break;
               case "hiraganaChi":     hiraganaChiLvl--;    break;
               case "hiraganaTsu":     hiraganaTsuLvl--;    break;
               case "hiraganaTe":      hiraganaTeLvl--;     break;
               case "hiraganaTo":      hiraganaToLvl--;     break;
               case "hiraganaNa":      hiraganaNaLvl--;     break;
               case "hiraganaNi":      hiraganaNiLvl--;     break;
               case "hiraganaNu":      hiraganaNuLvl--;     break;
               case "hiraganaNe":      hiraganaNeLvl--;     break;
               case "hiraganaNo":      hiraganaNoLvl--;     break;
               case "hiraganaHa":      hiraganaHaLvl--;     break;
               case "hiraganaHi":      hiraganaHiLvl--;     break;
               case "hiraganaHu":      hiraganaHuLvl--;     break;
               case "hiraganaHe":      hiraganaHeLvl--;     break;
               case "hiraganaHo":      hiraganaHoLvl--;     break;
               case "hiraganaMa":      hiraganaMaLvl--;     break;
               case "hiraganaMi":      hiraganaMiLvl--;     break;
               case "hiraganaMu":      hiraganaMuLvl--;     break;
               case "hiraganaMe":      hiraganaMeLvl--;     break;
               case "hiraganaMo":      hiraganaMoLvl--;     break;
               case "hiraganaRa":      hiraganaRaLvl--;     break;
               case "hiraganaRi":      hiraganaRiLvl--;     break;
               case "hiraganaRu":      hiraganaRuLvl--;     break;
               case "hiraganaRe":      hiraganaReLvl--;     break;
               case "hiraganaRo":      hiraganaRoLvl--;     break;
               case "hiraganaYa":      hiraganaYaLvl--;     break;
               case "hiraganaYu":      hiraganaYuLvl--;     break;
               case "hiraganaYo":      hiraganaYoLvl--;     break;
               case "hiraganaWa":      hiraganaWaLvl--;     break;
               case "hiraganaWo":      hiraganaWoLvl--;     break;
               case "hiraganaN":       hiraganaNLvl--;      break;
               case "hiraganaGa":      hiraganaGaLvl--;     break;
               case "hiraganaGi":      hiraganaGiLvl--;     break;
               case "hiraganaGu":      hiraganaGuLvl--;     break;
               case "hiraganaGe":      hiraganaGeLvl--;     break;
               case "hiraganaGo":      hiraganaGoLvl--;     break;
               case "hiraganaZa":      hiraganaZaLvl--;     break;
               case "hiraganaJi":      hiraganaJiLvl--;     break;
               case "hiraganaZu":      hiraganaZuLvl--;     break;
               case "hiraganaZe":      hiraganaZeLvl--;     break;
               case "hiraganaZo":      hiraganaZoLvl--;     break;
               case "hiraganaDa":      hiraganaDaLvl--;     break;
               case "hiraganaDi":      hiraganaDiLvl--;     break;
               case "hiraganaDu":      hiraganaDuLvl--;     break;
               case "hiraganaDe":      hiraganaDeLvl--;     break;
               case "hiraganaDo":      hiraganaDoLvl--;     break;
               case "hiraganaBa":      hiraganaBaLvl--;     break;
               case "hiraganaBi":      hiraganaBiLvl--;     break;
               case "hiraganaBu":      hiraganaBuLvl--;     break;
               case "hiraganaBe":      hiraganaBeLvl--;     break;
               case "hiraganaBo":      hiraganaBoLvl--;     break;
               case "hiraganaPa":      hiraganaPaLvl--;     break;
               case "hiraganaPi":      hiraganaPiLvl--;     break;
               case "hiraganaPu":      hiraganaPuLvl--;     break;
               case "hiraganaPe":      hiraganaPeLvl--;     break;
               case "hiraganaPo":      hiraganaPoLvl--;     break;
               case "hiraganaKya":     hiraganaKyaLvl--;     break;
               case "hiraganaKyu":     hiraganaKyuLvl--;     break;
               case "hiraganaKyo":     hiraganaKyoLvl--;     break;
               case "hiraganaSha":     hiraganaShaLvl--;     break;
               case "hiraganaShu":     hiraganaShuLvl--;     break;
               case "hiraganaSho":     hiraganaShoLvl--;     break;
               case "hiraganaCha":     hiraganaChaLvl--;     break;
               case "hiraganaChu":     hiraganaChuLvl--;     break;
               case "hiraganaCho":     hiraganaChoLvl--;     break;
               case "hiraganaHya":     hiraganaHyaLvl--;     break;
               case "hiraganaHyu":     hiraganaHyuLvl--;     break;
               case "hiraganaHyo":     hiraganaHyoLvl--;     break;
               case "hiraganaNya":     hiraganaNyaLvl--;     break;
               case "hiraganaNyu":     hiraganaNyuLvl--;     break;
               case "hiraganaNyo":     hiraganaNyoLvl--;     break;
               case "hiraganaMya":     hiraganaMyaLvl--;     break;
               case "hiraganaMyu":     hiraganaMyuLvl--;     break;
               case "hiraganaMyo":     hiraganaMyoLvl--;     break;
               case "hiraganaRya":     hiraganaRyaLvl--;     break;
               case "hiraganaRyu":     hiraganaRyuLvl--;     break;
               case "hiraganaRyo":     hiraganaRyoLvl--;     break;
               case "hiraganaGya":     hiraganaGyaLvl--;     break;
               case "hiraganaGyu":     hiraganaGyuLvl--;     break;
               case "hiraganaGyo":     hiraganaGyoLvl--;     break;
               case "hiraganaJya":     hiraganaJyaLvl--;     break;
               case "hiraganaJyu":     hiraganaJyuLvl--;     break;
               case "hiraganaJyo":     hiraganaJyoLvl--;     break;
               case "hiraganaDya":     hiraganaDyaLvl--;     break;
               case "hiraganaDyu":     hiraganaDyuLvl--;     break;
               case "hiraganaDyo":     hiraganaDyoLvl--;     break;
               case "hiraganaBya":     hiraganaByaLvl--;     break;
               case "hiraganaByu":     hiraganaByuLvl--;     break;
               case "hiraganaByo":     hiraganaByoLvl--;     break;
               case "hiraganaPya":     hiraganaPyaLvl--;     break;
               case "hiraganaPyu":     hiraganaPyuLvl--;     break;
               case "hiraganaPyo":     hiraganaPyoLvl--;     break;
               case "katakanaA":       katakanaALvl--;    break;
               case "katakanaI":       katakanaILvl--;    break;
               case "katakanaU":       katakanaULvl--;    break;
               case "katakanaE":       katakanaELvl--;    break;
               case "katakanaO":       katakanaOLvl--;    break;
               case "katakanaKa":      katakanaKaLvl--;     break;
               case "katakanaKi":      katakanaKiLvl--;     break;
               case "katakanaKu":      katakanaKuLvl--;     break;
               case "katakanaKe":      katakanaKeLvl--;     break;
               case "katakanaKo":      katakanaKoLvl--;     break;
               case "katakanaSa":      katakanaSaLvl--;     break;
               case "katakanaShi":     katakanaShiLvl--;    break;
               case "katakanaSu":      katakanaSuLvl--;     break;
               case "katakanaSe":      katakanaSeLvl--;     break;
               case "katakanaSo":      katakanaSoLvl--;     break;
               case "katakanaTa":      katakanaTaLvl--;     break;
               case "katakanaChi":     katakanaChiLvl--;    break;
               case "katakanaTsu":     katakanaTsuLvl--;    break;
               case "katakanaTe":      katakanaTeLvl--;     break;
               case "katakanaTo":      katakanaToLvl--;     break;
               case "katakanaNa":      katakanaNaLvl--;     break;
               case "katakanaNi":      katakanaNiLvl--;     break;
               case "katakanaNu":      katakanaNuLvl--;     break;
               case "katakanaNe":      katakanaNeLvl--;     break;
               case "katakanaNo":      katakanaNoLvl--;     break;
               case "katakanaHa":      katakanaHaLvl--;     break;
               case "katakanaHi":      katakanaHiLvl--;     break;
               case "katakanaHu":      katakanaHuLvl--;     break;
               case "katakanaHe":      katakanaHeLvl--;     break;
               case "katakanaHo":      katakanaHoLvl--;     break;
               case "katakanaMa":      katakanaMaLvl--;     break;
               case "katakanaMi":      katakanaMiLvl--;     break;
               case "katakanaMu":      katakanaMuLvl--;     break;
               case "katakanaMe":      katakanaMeLvl--;     break;
               case "katakanaMo":      katakanaMoLvl--;     break;
               case "katakanaRa":      katakanaRaLvl--;     break;
               case "katakanaRi":      katakanaRiLvl--;     break;
               case "katakanaRu":      katakanaRuLvl--;     break;
               case "katakanaRe":      katakanaReLvl--;     break;
               case "katakanaRo":      katakanaRoLvl--;     break;
               case "katakanaYa":      katakanaYaLvl--;     break;
               case "katakanaYu":      katakanaYuLvl--;     break;
               case "katakanaYo":      katakanaYoLvl--;     break;
               case "katakanaWa":      katakanaWaLvl--;     break;
               case "katakanaWo":      katakanaWoLvl--;     break;
               case "katakanaN":       katakanaNLvl--;      break;
               case "katakanaGa":      katakanaGaLvl--;     break;
               case "katakanaGi":      katakanaGiLvl--;     break;
               case "katakanaGu":      katakanaGuLvl--;     break;
               case "katakanaGe":      katakanaGeLvl--;     break;
               case "katakanaGo":      katakanaGoLvl--;     break;
               case "katakanaZa":      katakanaZaLvl--;     break;
               case "katakanaJi":      katakanaJiLvl--;     break;
               case "katakanaZu":      katakanaZuLvl--;     break;
               case "katakanaZe":      katakanaZeLvl--;     break;
               case "katakanaZo":      katakanaZoLvl--;     break;
               case "katakanaDa":      katakanaDaLvl--;     break;
               case "katakanaDi":      katakanaDiLvl--;     break;
               case "katakanaDu":      katakanaDuLvl--;     break;
               case "katakanaDe":      katakanaDeLvl--;     break;
               case "katakanaDo":      katakanaDoLvl--;     break;
               case "katakanaBa":      katakanaBaLvl--;     break;
               case "katakanaBi":      katakanaBiLvl--;     break;
               case "katakanaBu":      katakanaBuLvl--;     break;
               case "katakanaBe":      katakanaBeLvl--;     break;
               case "katakanaBo":      katakanaBoLvl--;     break;
               case "katakanaPa":      katakanaPaLvl--;     break;
               case "katakanaPi":      katakanaPiLvl--;     break;
               case "katakanaPu":      katakanaPuLvl--;     break;
               case "katakanaPe":      katakanaPeLvl--;     break;
               case "katakanaPo":      katakanaPoLvl--;     break;
               case "katakanaKya":     katakanaKyaLvl--;     break;
               case "katakanaKyu":     katakanaKyuLvl--;     break;
               case "katakanaKyo":     katakanaKyoLvl--;     break;
               case "katakanaSha":     katakanaShaLvl--;     break;
               case "katakanaShu":     katakanaShuLvl--;     break;
               case "katakanaSho":     katakanaShoLvl--;     break;
               case "katakanaCha":     katakanaChaLvl--;     break;
               case "katakanaChu":     katakanaChuLvl--;     break;
               case "katakanaCho":     katakanaChoLvl--;     break;
               case "katakanaHya":     katakanaHyaLvl--;     break;
               case "katakanaHyu":     katakanaHyuLvl--;     break;
               case "katakanaHyo":     katakanaHyoLvl--;     break;
               case "katakanaNya":     katakanaNyaLvl--;     break;
               case "katakanaNyu":     katakanaNyuLvl--;     break;
               case "katakanaNyo":     katakanaNyoLvl--;     break;
               case "katakanaMya":     katakanaMyaLvl--;     break;
               case "katakanaMyu":     katakanaMyuLvl--;     break;
               case "katakanaMyo":     katakanaMyoLvl--;     break;
               case "katakanaRya":     katakanaRyaLvl--;     break;
               case "katakanaRyu":     katakanaRyuLvl--;     break;
               case "katakanaRyo":     katakanaRyoLvl--;     break;
               case "katakanaGya":     katakanaGyaLvl--;     break;
               case "katakanaGyu":     katakanaGyuLvl--;     break;
               case "katakanaGyo":     katakanaGyoLvl--;     break;
               case "katakanaJya":     katakanaJyaLvl--;     break;
               case "katakanaJyu":     katakanaJyuLvl--;     break;
               case "katakanaJyo":     katakanaJyoLvl--;     break;
               case "katakanaDya":     katakanaDyaLvl--;     break;
               case "katakanaDyu":     katakanaDyuLvl--;     break;
               case "katakanaDyo":     katakanaDyoLvl--;     break;
               case "katakanaBya":     katakanaByaLvl--;     break;
               case "katakanaByu":     katakanaByuLvl--;     break;
               case "katakanaByo":     katakanaByoLvl--;     break;
               case "katakanaPya":     katakanaPyaLvl--;     break;
               case "katakanaPyu":     katakanaPyuLvl--;     break;
               case "katakanaPyo":     katakanaPyoLvl--;     break;
               default: break;

          }
     }

     public static boolean areAllHiraganaMemorised(){
          return allHiraganaMemorised;
     }

     public static void setAllHiraganaMemorisedToTrue(){

          allHiraganaMemorised = true;

          hiraganaALvl = 3;      hiraganaKaLvl = 3;
          hiraganaILvl = 3;      hiraganaKiLvl = 3;
          hiraganaULvl = 3;      hiraganaKuLvl = 3;
          hiraganaELvl = 3;      hiraganaKeLvl = 3;
          hiraganaOLvl = 3;      hiraganaKoLvl = 3;

          hiraganaSaLvl = 3;     hiraganaTaLvl = 3;
          hiraganaShiLvl = 3;    hiraganaChiLvl = 3;
          hiraganaSuLvl = 3;     hiraganaTsuLvl = 3;
          hiraganaSeLvl = 3;     hiraganaTeLvl = 3;
          hiraganaSoLvl = 3;     hiraganaToLvl = 3;

          hiraganaNaLvl = 3;     hiraganaHaLvl = 3;
          hiraganaNiLvl = 3;     hiraganaHiLvl = 3;
          hiraganaNuLvl = 3;     hiraganaHuLvl = 3;
          hiraganaNeLvl = 3;     hiraganaHeLvl = 3;
          hiraganaNoLvl = 3;     hiraganaHoLvl = 3;

          hiraganaMaLvl = 3;     hiraganaRaLvl = 3;
          hiraganaMiLvl = 3;     hiraganaRiLvl = 3;
          hiraganaMuLvl = 3;     hiraganaRuLvl = 3;
          hiraganaMeLvl = 3;     hiraganaReLvl = 3;
          hiraganaMoLvl = 3;     hiraganaRoLvl = 3;

          hiraganaNLvl  = 3;

          hiraganaGaLvl = 3;     hiraganaZaLvl = 3;
          hiraganaGiLvl = 3;     hiraganaJiLvl = 3;
          hiraganaGuLvl = 3;     hiraganaZuLvl = 3;
          hiraganaGeLvl = 3;     hiraganaZeLvl = 3;
          hiraganaGoLvl = 3;     hiraganaZoLvl = 3;

          hiraganaDaLvl = 3;     hiraganaBaLvl = 3;
          hiraganaDiLvl = 3;     hiraganaBiLvl = 3;
          hiraganaDuLvl = 3;     hiraganaBuLvl = 3;
          hiraganaDeLvl = 3;     hiraganaBeLvl = 3;
          hiraganaDoLvl = 3;     hiraganaBoLvl = 3;

          hiraganaPaLvl = 3;     hiraganaYaLvl = 3;
          hiraganaPiLvl = 3;     hiraganaYuLvl = 3;
          hiraganaPuLvl = 3;     hiraganaYoLvl = 3;
          hiraganaPeLvl = 3;     hiraganaWaLvl = 3;
          hiraganaPoLvl = 3;     hiraganaWoLvl = 3;

          hiraganaKyaLvl = 3;    hiraganaShaLvl = 3;
          hiraganaKyuLvl = 3;    hiraganaShuLvl = 3;
          hiraganaKyoLvl = 3;    hiraganaShoLvl = 3;

          hiraganaChaLvl = 3;    hiraganaHyaLvl = 3;
          hiraganaChuLvl = 3;    hiraganaHyuLvl = 3;
          hiraganaChoLvl = 3;    hiraganaHyoLvl = 3;

          hiraganaNyaLvl = 3;    hiraganaMyaLvl = 3;
          hiraganaNyuLvl = 3;    hiraganaMyuLvl = 3;
          hiraganaNyoLvl = 3;    hiraganaMyoLvl = 3;

          hiraganaRyaLvl = 3;    hiraganaGyaLvl = 3;
          hiraganaRyuLvl = 3;    hiraganaGyuLvl = 3;
          hiraganaRyoLvl = 3;    hiraganaGyoLvl = 3;

          hiraganaJyaLvl = 3;    hiraganaDyaLvl = 3;
          hiraganaJyuLvl = 3;    hiraganaDyuLvl = 3;
          hiraganaJyoLvl = 3;    hiraganaDyoLvl = 3;

          hiraganaByaLvl = 3;    hiraganaPyaLvl = 3;
          hiraganaByuLvl = 3;    hiraganaPyuLvl = 3;
          hiraganaByoLvl = 3;    hiraganaPyoLvl = 3;

     }

     public static void setAllHiraganaMemorisedToFalse(){

          allHiraganaMemorised = false;

          hiraganaALvl = 1;      hiraganaKaLvl = 1;
          hiraganaILvl = 1;      hiraganaKiLvl = 1;
          hiraganaULvl = 1;      hiraganaKuLvl = 1;
          hiraganaELvl = 1;      hiraganaKeLvl = 1;
          hiraganaOLvl = 1;      hiraganaKoLvl = 1;

          hiraganaSaLvl = 1;     hiraganaTaLvl = 1;
          hiraganaShiLvl = 1;    hiraganaChiLvl = 1;
          hiraganaSuLvl = 1;     hiraganaTsuLvl = 1;
          hiraganaSeLvl = 1;     hiraganaTeLvl = 1;
          hiraganaSoLvl = 1;     hiraganaToLvl = 1;

          hiraganaNaLvl = 1;     hiraganaHaLvl = 1;
          hiraganaNiLvl = 1;     hiraganaHiLvl = 1;
          hiraganaNuLvl = 1;     hiraganaHuLvl = 1;
          hiraganaNeLvl = 1;     hiraganaHeLvl = 1;
          hiraganaNoLvl = 1;     hiraganaHoLvl = 1;

          hiraganaMaLvl = 1;     hiraganaRaLvl = 1;
          hiraganaMiLvl = 1;     hiraganaRiLvl = 1;
          hiraganaMuLvl = 1;     hiraganaRuLvl = 1;
          hiraganaMeLvl = 1;     hiraganaReLvl = 1;
          hiraganaMoLvl = 1;     hiraganaRoLvl = 1;

          hiraganaNLvl  = 1;

          hiraganaGaLvl = 1;     hiraganaZaLvl = 1;
          hiraganaGiLvl = 1;     hiraganaJiLvl = 1;
          hiraganaGuLvl = 1;     hiraganaZuLvl = 1;
          hiraganaGeLvl = 1;     hiraganaZeLvl = 1;
          hiraganaGoLvl = 1;     hiraganaZoLvl = 1;

          hiraganaDaLvl = 1;     hiraganaBaLvl = 1;
          hiraganaDiLvl = 1;     hiraganaBiLvl = 1;
          hiraganaDuLvl = 1;     hiraganaBuLvl = 1;
          hiraganaDeLvl = 1;     hiraganaBeLvl = 1;
          hiraganaDoLvl = 1;     hiraganaBoLvl = 1;

          hiraganaPaLvl = 1;     hiraganaYaLvl = 1;
          hiraganaPiLvl = 1;     hiraganaYuLvl = 1;
          hiraganaPuLvl = 1;     hiraganaYoLvl = 1;
          hiraganaPeLvl = 1;     hiraganaWaLvl = 1;
          hiraganaPoLvl = 1;     hiraganaWoLvl = 1;

          hiraganaKyaLvl = 1;    hiraganaShaLvl = 1;
          hiraganaKyuLvl = 1;    hiraganaShuLvl = 1;
          hiraganaKyoLvl = 1;    hiraganaShoLvl = 1;

          hiraganaChaLvl = 1;    hiraganaHyaLvl = 1;
          hiraganaChuLvl = 1;    hiraganaHyuLvl = 1;
          hiraganaChoLvl = 1;    hiraganaHyoLvl = 1;

          hiraganaNyaLvl = 1;    hiraganaMyaLvl = 1;
          hiraganaNyuLvl = 1;    hiraganaMyuLvl = 1;
          hiraganaNyoLvl = 1;    hiraganaMyoLvl = 1;

          hiraganaRyaLvl = 1;    hiraganaGyaLvl = 1;
          hiraganaRyuLvl = 1;    hiraganaGyuLvl = 1;
          hiraganaRyoLvl = 1;    hiraganaGyoLvl = 1;

          hiraganaJyaLvl = 1;    hiraganaDyaLvl = 1;
          hiraganaJyuLvl = 1;    hiraganaDyuLvl = 1;
          hiraganaJyoLvl = 1;    hiraganaDyoLvl = 1;

          hiraganaByaLvl = 1;    hiraganaPyaLvl = 1;
          hiraganaByuLvl = 1;    hiraganaPyuLvl = 1;
          hiraganaByoLvl = 1;    hiraganaPyoLvl = 1;

     }

     public static boolean areAllKatakanaMemorised(){
          return allKatakanaMemorised;
     }

     public static void setAllkatakanaMemorisedToTrue(){

          allKatakanaMemorised = true;

          katakanaALvl = 3;      katakanaKaLvl = 3;
          katakanaILvl = 3;      katakanaKiLvl = 3;
          katakanaULvl = 3;      katakanaKuLvl = 3;
          katakanaELvl = 3;      katakanaKeLvl = 3;
          katakanaOLvl = 3;      katakanaKoLvl = 3;

          katakanaSaLvl = 3;     katakanaTaLvl = 3;
          katakanaShiLvl = 3;    katakanaChiLvl = 3;
          katakanaSuLvl = 3;     katakanaTsuLvl = 3;
          katakanaSeLvl = 3;     katakanaTeLvl = 3;
          katakanaSoLvl = 3;     katakanaToLvl = 3;

          katakanaNaLvl = 3;     katakanaHaLvl = 3;
          katakanaNiLvl = 3;     katakanaHiLvl = 3;
          katakanaNuLvl = 3;     katakanaHuLvl = 3;
          katakanaNeLvl = 3;     katakanaHeLvl = 3;
          katakanaNoLvl = 3;     katakanaHoLvl = 3;

          katakanaMaLvl = 3;     katakanaRaLvl = 3;
          katakanaMiLvl = 3;     katakanaRiLvl = 3;
          katakanaMuLvl = 3;     katakanaRuLvl = 3;
          katakanaMeLvl = 3;     katakanaReLvl = 3;
          katakanaMoLvl = 3;     katakanaRoLvl = 3;

          katakanaNLvl  = 3;

          katakanaGaLvl = 3;     katakanaZaLvl = 3;
          katakanaGiLvl = 3;     katakanaJiLvl = 3;
          katakanaGuLvl = 3;     katakanaZuLvl = 3;
          katakanaGeLvl = 3;     katakanaZeLvl = 3;
          katakanaGoLvl = 3;     katakanaZoLvl = 3;

          katakanaDaLvl = 3;     katakanaBaLvl = 3;
          katakanaDiLvl = 3;     katakanaBiLvl = 3;
          katakanaDuLvl = 3;     katakanaBuLvl = 3;
          katakanaDeLvl = 3;     katakanaBeLvl = 3;
          katakanaDoLvl = 3;     katakanaBoLvl = 3;

          katakanaPaLvl = 3;     katakanaYaLvl = 3;
          katakanaPiLvl = 3;     katakanaYuLvl = 3;
          katakanaPuLvl = 3;     katakanaYoLvl = 3;
          katakanaPeLvl = 3;     katakanaWaLvl = 3;
          katakanaPoLvl = 3;     katakanaWoLvl = 3;

          katakanaKyaLvl = 3;    katakanaShaLvl = 3;
          katakanaKyuLvl = 3;    katakanaShuLvl = 3;
          katakanaKyoLvl = 3;    katakanaShoLvl = 3;

          katakanaChaLvl = 3;    katakanaHyaLvl = 3;
          katakanaChuLvl = 3;    katakanaHyuLvl = 3;
          katakanaChoLvl = 3;    katakanaHyoLvl = 3;

          katakanaNyaLvl = 3;    katakanaMyaLvl = 3;
          katakanaNyuLvl = 3;    katakanaMyuLvl = 3;
          katakanaNyoLvl = 3;    katakanaMyoLvl = 3;

          katakanaRyaLvl = 3;    katakanaGyaLvl = 3;
          katakanaRyuLvl = 3;    katakanaGyuLvl = 3;
          katakanaRyoLvl = 3;    katakanaGyoLvl = 3;

          katakanaJyaLvl = 3;    katakanaDyaLvl = 3;
          katakanaJyuLvl = 3;    katakanaDyuLvl = 3;
          katakanaJyoLvl = 3;    katakanaDyoLvl = 3;

          katakanaByaLvl = 3;    katakanaPyaLvl = 3;
          katakanaByuLvl = 3;    katakanaPyuLvl = 3;
          katakanaByoLvl = 3;    katakanaPyoLvl = 3;

     }

     public static void setAllkatakanaMemorisedToFalse(){

          allKatakanaMemorised = false;

          katakanaALvl = 1;      katakanaKaLvl = 1;
          katakanaILvl = 1;      katakanaKiLvl = 1;
          katakanaULvl = 1;      katakanaKuLvl = 1;
          katakanaELvl = 1;      katakanaKeLvl = 1;
          katakanaOLvl = 1;      katakanaKoLvl = 1;

          katakanaSaLvl = 1;     katakanaTaLvl = 1;
          katakanaShiLvl = 1;    katakanaChiLvl = 1;
          katakanaSuLvl = 1;     katakanaTsuLvl = 1;
          katakanaSeLvl = 1;     katakanaTeLvl = 1;
          katakanaSoLvl = 1;     katakanaToLvl = 1;

          katakanaNaLvl = 1;     katakanaHaLvl = 1;
          katakanaNiLvl = 1;     katakanaHiLvl = 1;
          katakanaNuLvl = 1;     katakanaHuLvl = 1;
          katakanaNeLvl = 1;     katakanaHeLvl = 1;
          katakanaNoLvl = 1;     katakanaHoLvl = 1;

          katakanaMaLvl = 1;     katakanaRaLvl = 1;
          katakanaMiLvl = 1;     katakanaRiLvl = 1;
          katakanaMuLvl = 1;     katakanaRuLvl = 1;
          katakanaMeLvl = 1;     katakanaReLvl = 1;
          katakanaMoLvl = 1;     katakanaRoLvl = 1;

          katakanaNLvl  = 1;

          katakanaGaLvl = 1;     katakanaZaLvl = 1;
          katakanaGiLvl = 1;     katakanaJiLvl = 1;
          katakanaGuLvl = 1;     katakanaZuLvl = 1;
          katakanaGeLvl = 1;     katakanaZeLvl = 1;
          katakanaGoLvl = 1;     katakanaZoLvl = 1;

          katakanaDaLvl = 1;     katakanaBaLvl = 1;
          katakanaDiLvl = 1;     katakanaBiLvl = 1;
          katakanaDuLvl = 1;     katakanaBuLvl = 1;
          katakanaDeLvl = 1;     katakanaBeLvl = 1;
          katakanaDoLvl = 1;     katakanaBoLvl = 1;

          katakanaPaLvl = 1;     katakanaYaLvl = 1;
          katakanaPiLvl = 1;     katakanaYuLvl = 1;
          katakanaPuLvl = 1;     katakanaYoLvl = 1;
          katakanaPeLvl = 1;     katakanaWaLvl = 1;
          katakanaPoLvl = 1;     katakanaWoLvl = 1;

          katakanaKyaLvl = 1;    katakanaShaLvl = 1;
          katakanaKyuLvl = 1;    katakanaShuLvl = 1;
          katakanaKyoLvl = 1;    katakanaShoLvl = 1;

          katakanaChaLvl = 1;    katakanaHyaLvl = 1;
          katakanaChuLvl = 1;    katakanaHyuLvl = 1;
          katakanaChoLvl = 1;    katakanaHyoLvl = 1;

          katakanaNyaLvl = 1;    katakanaMyaLvl = 1;
          katakanaNyuLvl = 1;    katakanaMyuLvl = 1;
          katakanaNyoLvl = 1;    katakanaMyoLvl = 1;

          katakanaRyaLvl = 1;    katakanaGyaLvl = 1;
          katakanaRyuLvl = 1;    katakanaGyuLvl = 1;
          katakanaRyoLvl = 1;    katakanaGyoLvl = 1;

          katakanaJyaLvl = 1;    katakanaDyaLvl = 1;
          katakanaJyuLvl = 1;    katakanaDyuLvl = 1;
          katakanaJyoLvl = 1;    katakanaDyoLvl = 1;

          katakanaByaLvl = 1;    katakanaPyaLvl = 1;
          katakanaByuLvl = 1;    katakanaPyuLvl = 1;
          katakanaByoLvl = 1;    katakanaPyoLvl = 1;

     }


}
