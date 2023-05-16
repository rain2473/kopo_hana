select "all"."지자체", "all"."어린이집", "public"."국공립어린이집", round("public"."국공립어린이집" / "all"."어린이집"*100,1) as "국공립(%)"
from(
select city_county as 지자체, count(city_county) as 어린이집 from daycare group by city_county order by city_county
) "all"
LEFT JOIN(
select city_county, count(city_county) as 국공립어린이집 from daycare where category = '국공립' group by city_county order by city_county
) "public"
on "all"."지자체" = "public".city_county
order by "all"."지자체" asc;

select "all"."지자체", "all"."열린육아방", NVL("free"."무료육아방",0) as "무료육아방", round(NVL("free"."무료육아방",0) / "all"."열린육아방"*100,1) as "무료육아방(%)"
from(
select city_county as 지자체, count(city_county) as "열린육아방" from open group by city_county order by city_county
) "all"
LEFT JOIN(
select city_county, count(city_county) as "무료육아방" from open where fee =0 group by city_county order by city_county
) "free"
on "all"."지자체" = "free".city_county
order by "all"."지자체" asc;


select "all"."지자체", "all"."우리동네키움센터", NVL("free"."무료키움센터",0) as "무료키움센터", round(NVL("free"."무료키움센터",0) / "all"."우리동네키움센터"*100,1) as "무료키움센터(%)"
from(
select city_county as 지자체, count(city_county) as "우리동네키움센터" from kiwoom group by city_county order by city_county
) "all"
LEFT JOIN(
select city_county, count(city_county) as "무료키움센터" from kiwoom where fee =0 group by city_county order by city_county
) "free"
on "all"."지자체" = "free".city_county
order by "all"."지자체" asc;


SELECT "joined"."지자체", "joined"."어린이집", "joined"."열린육아방", "kiwoom"."우리동네키움센터"
FROM 
(SELECT "daycare"."지자체", "daycare"."어린이집", NVL("open"."열린육아방",0) as "열린육아방"
    FROM (
        select city_county as "지자체", count(city_county) as "어린이집" from daycare group by city_county order by city_county
        ) "daycare"
        LEFT OUTER JOIN (
        select city_county, count(city_county) as "열린육아방" from open group by city_county order by city_county
        ) "open"
        ON "daycare"."지자체" = "open".city_county
        order by city_county asc
    ) "joined"
    LEFT OUTER JOIN (
    select city_county, count(city_county) as "우리동네키움센터" from kiwoom group by city_county order by city_county
    ) "kiwoom"
     ON "joined"."지자체" = "kiwoom".city_county
order by city_county asc
;