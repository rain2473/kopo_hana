SELECT joined.지자체, joined.어린이집, joined.열린육아방, city_kiwoom.우리동네키움센터, joined.국공립비율, joined.무료육아방비율, city_kiwoom.무료키움센터비율
FROM (SELECT city_daycare.지자체, city_daycare.어린이집, city_daycare.국공립비율, city_open.열린육아방, city_open.무료육아방비율
FROM city_daycare
LEFT OUTER JOIN
city_open
ON city_daycare.지자체 = city_open.지자체
) joined
LEFT OUTER JOIN
city_kiwoom
ON joined.지자체 = city_kiwoom.지자체
order by 무료키움센터비율 desc, 우리동네키움센터 desc;