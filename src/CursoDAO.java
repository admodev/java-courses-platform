import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    public List<CursoDTO> getCursos() {
        // query
        String sql = "";
        sql += "SELECT id_curso ";
        sql += "        ,descripcion ";
        sql += "        ,precio ";
        sql += "FROM curso ";

        // ejecutar query
        try (Connection con =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admocode")
             ; PreparedStatement pstm =
                     con.prepareStatement(sql)
             ; ResultSet rs = pstm.executeQuery()) {
            List<CursoDTO> lst = new ArrayList<>();
            while (rs.next()) {
                CursoDTO dto = new CursoDTO();
                dto.setIdCurso(rs.getInt("id_curso"));
                dto.setDescripcion(rs.getString("descripcion"));
                dto.setPrecio(rs.getDouble("precio"));
                lst.add(dto);
            }

            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
