import com.database.CSVReader;
import com.database.CustomerInvoicePOJO;
import com.database.MySQLTool;

import java.util.ArrayList;

public class Solution {
        public static void main(String[] args) {
        CSVReader file = new CSVReader("src/DataUploading.csv");
        ArrayList<CustomerInvoicePOJO> POJOS = file.get_ArrayList_of_POJO();

		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");
		for (CustomerInvoicePOJO x:POJOS) {
			DB.insert_query("insert into customer_invoice ("+x.comma_separated_keys()+") values ("+x.comma_separated_values()+")");
		}
    }
}

