import com.google.common.collect.Lists
import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Usage
import org.springframework.beans.factory.support.DefaultListableBeanFactory

import javax.sql.DataSource

class airbus{

    @Usage("Main Method Get Bean From Context")
    @Command
    def main(@Option(names=["n","beanName"]) String beanName){
        def attr = (DefaultListableBeanFactory)context.attributes["spring.beanfactory"];
        if(null != beanName && beanName.trim() != ''){
            return attr.getBean(beanName)
        }
        return null;
    }

    @Usage("Execute Sql")
    @Command
    Boolean sqlExecute(@Option(names=["sql"]) String sql){
        DataSource dataSource = (DataSource)get("dataSource");
        if(null != dataSource && null != sql && sql.trim() != ''){
            def Sql = new Sql(dataSource);
            try{
                return Sql.execute(sql);
            }finally{
                Sql.close();
            }
        }
        return false;
    }

    @Usage("Query Sql")
    @Command
    List<GroovyRowResult> sqlQuery(@Option(names=["sql"]) String sql){
        DataSource dataSource = (DataSource)get("dataSource");
        if(null != dataSource && null != sql && sql.trim() != ''){
            def Sql = new Sql(dataSource);
            try{
                return Sql.rows(sql);
            }finally{
                Sql.close();
            }
        }
        return Lists.newArrayList();
    }

}