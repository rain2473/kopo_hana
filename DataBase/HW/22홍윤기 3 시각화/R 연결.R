install.packages('rJava')
install.packages('RJDBC')
install.packages('ggplot2')
install.packages('dplyr')


library(rJava)
library(RJDBC)
library('ggplot2')
library(dplyr)


jdbcDriver <- JDBC(driverClass = "oracle.jdbc.OracleDriver",
                   classPath = "/Users/Hong-YoonKi/Downloads/ojdbc11.jar")

conn <- dbConnect(jdbcDriver, 
                  "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger")

test <- dbGetQuery(conn, 
"SELECT joined.지자체, joined.어린이집, joined.열린육아방, city_kiwoom.우리동네키움센터, joined.국공립비율, joined.무료육아방비율, city_kiwoom.무료키움센터비율
FROM (SELECT city_day.지자체, city_day.어린이집, city_day.국공립비율, city_open.열린육아방, city_open.무료육아방비율
FROM city_day
LEFT OUTER JOIN
city_open
ON city_day.지자체 = city_open.지자체
) joined
LEFT OUTER JOIN
city_kiwoom
ON joined.지자체 = city_kiwoom.지자체
order by 무료키움센터비율 desc, 우리동네키움센터 desc")
test

ggplot(data = test, aes(x = '지자체', y = '어린이집')) + geom_bar(stat = "identity") + labs(x = "Municipality", y = "Number of Daycare Centers") + theme(axis.text.x = element_text(angle = 90, hjust = 1))

numeric_cols <- c("어린이집", "열린육아방", "우리동네키움센터", "국공립비율", "무료육아방비율", "무료키움센터비율")

numeric_cols

test[numeric_cols] <- sapply(test[numeric_cols], as.numeric)

daycare <- test %>% arrange(desc(어린이집)) %>% head(25)

daycare <- daycare%>% select("지자체", "어린이집", "열린육아방", "우리동네키움센터", "국공립비율", "무료육아방비율", "무료키움센터비율") %>% pivot_longer(cols = -지자체, names_to = "variable", values_to = "value")

daycare

ggplot(happniess, aes(x = "지자체", y = value, fill = variable)) + geom_col(position = "stack") + scale_fill_manual(values = c("어린이집" = "#00BFFF", "열린육아방" = "#00FA9A", "우리동네키움센터" = "#FFD700", theme(axis.text.x = element_text(angle = 45, hjust = 1)) + labs(x = "지자체", y = "시설수", fill = "Factors")
                                                                                                                            
                                                                                                                            