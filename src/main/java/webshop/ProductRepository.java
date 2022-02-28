package webshop;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

public class ProductRepository {


   private JdbcTemplate jdbcTemplate;

    public ProductRepository(MariaDbDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long insertProduct(String productName, int price, int stock){
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement prepStmt = con.prepareStatement("insert into products(product_name, price , stock ) values(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1,productName);
            prepStmt.setLong(2,price);
            prepStmt.setLong(3,stock);

            return prepStmt;
        }, holder);

        return Objects.requireNonNull(holder.getKey()).longValue();
    }

    public Product findProductById(long generatedId) {
        return jdbcTemplate.queryForObject("select * from products where id=?", (rs, rowNum) -> new Product(rs.getLong("id"),
                rs.getString("product_name"),rs.getInt("price"), rs.getInt("stock")), generatedId);
    }

    public void updateProductStock(long generatedId, int stock) {
        jdbcTemplate.update("update products set stock = stock-? where id = ?",stock,generatedId);
    }
}
