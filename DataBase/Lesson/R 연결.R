install.packages('rJava')
install.packages('RJDBC')
install.packages('ggplot2')
install.packages('extrafont')

library(rJava)
library(RJDBC)
library('ggplot2')
library('extrafont')

Sys.setlocale(category = "LC_ALL", locale = "ko_KR.UTF-8")

font_import()
theme_set(theme_gray(base_family='AppleMyungjo'))


jdbcDriver <- JDBC(driverClass = "oracle.jdbc.OracleDriver",
                   classPath = "/Users/Hong-YoonKi/Downloads/ojdbc11.jar")

conn <- dbConnect(jdbcDriver, 
                  "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger")

data <- dbGetQuery(conn, 
"SELECT joined.지자체, joined.어린이집, joined.열린육아방, city_kiwoom.우리동네키움센터, joined.국공립비율, joined.무료육아방비율, city_kiwoom.무료키움센터비율
FROM (SELECT city_daycare.지자체, city_daycare.어린이집, city_daycare.국공립비율, city_open.열린육아방, city_open.무료육아방비율
FROM city_daycare
LEFT OUTER JOIN
city_open
ON city_daycare.지자체 = city_open.지자체
) joined
LEFT OUTER JOIN
city_kiwoom
ON joined.지자체 = city_kiwoom.지자체
order by 무료키움센터비율 desc, 우리동네키움센터 desc")
data

ggplot(data, aes(x = 지자체, y = 어린이집)) + 
  geom_bar(stat = "identity", fill = "steelblue") +
  theme(axis.text.x = element_text(angle = 0, hjust = 1))

ggplot(data, aes(x = 지자체, y = 열린육아방)) + 
  geom_bar(stat = "identity", fill = 'orange') +
  theme(axis.text.x = element_text(angle = 0, hjust = 1))

ggplot(data, aes(x = 지자체, y = 우리동네키움센터)) + 
  geom_bar(stat = "identity", fill = "violet") +
  theme(axis.text.x = element_text(angle = 0, hjust = 1))
