##log4j
1.hello
    简介：
        主流的java日志框架，提供各种类型、各种格式、各种存储方式的多样化日志服务。
    编码：
        1.配置文件配置输出等级、输出地点、输出格式
            1.根配置log4j.rootLogger：把日志等级之上的错误输出到指定位置
                log4j.rootLogger  = 等级,地点1,地点2...
                    等级：从大到小，OFF FATAL ERROR WARN INFO DEBUG ALL。
                        官方建议用这4种：ERROR WARN INFO DEBUG。
                    地点：控制台和文件
                        控制台：org.apache.log4j.ConsoleAppender  
                        单文件：org.apache.log4j.FileAppender
                        每日一个文件：org.apache.log4j.DailyRollingFileAppender
                        固定大小文件：org.apache.log4j.RollingFileAppender
                            建议：
                                数据量不大，建议用每日一个文件
                                数据量很大，建议固定文件大小
        2.输出地点配置
            #Console  
            log4j.appender.Console=org.apache.log4j.ConsoleAppender  
            log4j.appender.Console.layout=org.apache.log4j.PatternLayout  
            log4j.appender.Console.layout.ConversionPattern=%d [%t] %-5p [%c] - %m%n         
            #File
            log4j.appender.File = org.apache.log4j.FileAppender
            log4j.appender.File.File = C://log2.log
            log4j.appender.File.layout = org.apache.log4j.PatternLayout
            log4j.appender.File.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n                         
            #DailyRollingFile
            log4j.appender.DailyRollingFile = org.apache.log4j.DailyRollingFileAppender
            log4j.appender.DailyRollingFile.File = C://log3.log
            log4j.appender.DailyRollingFile.layout = org.apache.log4j.PatternLayout
            log4j.appender.DailyRollingFile.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n            
            #RollingFile
            log4j.appender.RollingFile = org.apache.log4j.RollingFileAppender
            log4j.appender.RollingFile.File = C://log4.log
            log4j.appender.RollingFile.MaxFileSize=1KB      一个文件最大大小
            log4j.appender.RollingFile.MaxBackupIndex=3     文件最大数量，超过则循环覆盖
            log4j.appender.RollingFile.layout = org.apache.log4j.PatternLayout
            log4j.appender.RollingFile.layout.ConversionPattern =%d [%t] %-5p [%c] - %m%n
        3.输出格式
            首先选中输出布局类
                org.apache.log4j.HTMLLayout：带html标签。不需要指定格式。
                org.apache.log4j.PatternLayout：灵活指定格式，常用。
                org.apache.log4j.SimpleLayout：只包含等级和信息字符串，一般不用。不需要指定格式。
                org.apache.log4j.TTCCLayout：只包含方法和等级和类路径和信息。一般不用，不需要指定格式。
            然后指定输出格式
                log4j.appender.地点.layout.ConversionPattern=指定日志信息输出的格式 
                格式简介：只有PatternLayout才需要指定日志信息输出格式
                    比如：
                        %d [%t] %-5p [%c] - %m%n   
                        2019-01-06 00:07:12,260 [main] INFO  [com.xgao.log4jTest.Test] - 普通Info信息222
                    %d ：日志信息输出的时间，默认为ISO8601，可以指定格式%d{yyyy-MM-dd HH:mm:ss,SSS}
                    %p ：日志信息输出优先级， %-5p常用  占五个位置的意思，比如INF占三个位置，那-5后，则是INF空格空格。 
                    %c：记录的类路径
                    %t：日志信息输出所在的线程名 ，比如：main
                    %m：代码中指定的消息。
                    %n：换行的意思，Windows平台为%rn
        4.log4j.appender.地点.Threshold = 等级		//输出指定等级，其他等级不输出了，等级要在根配置输出等级范围内
        5.log4j.appender.地点.Append = boolean
            输出信息是否追加，默认true，追加。false，覆盖。没有人会用覆盖。
2.日志框架
    
   



SLF4J：Simple Logging Facade for Java的简写，即Java简单日志门面，也就是接口，用来服务于各种各样的日志框架
slf4j-api-1.7.19.jar。
单独的slf4j是不能工作的，必须搭配其他具体的日志实现方案，比如log4j或者log4j2，
slf4j入口就是众多接口的集合，它不负责具体的日志实现，只在编译时负责寻找合适的日志系统进行绑定。
Log4j：主流的java日志框架，提供各种类型、各种格式、各种存储方式的多样化日志服务。
如果我们在系统中需要使用slf4j和log4j来进行日志输出的话，我们需要引入下面的桥接jar包：
log4j核心jar包：log4j-1.2.17.jar
slf4j核心jar包：slf4j-api-1.6.4.jar
slf4j与log4j的桥接包：slf4j-log4j12-1.6.1.jar，