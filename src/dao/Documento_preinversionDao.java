package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Documento_preinversion;

public class Documento_preinversionDao implements Intermetodos<Documento_preinversion> {

	@Override
	public void Grabar(Documento_preinversion o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " insert into documento_preinversion("
					+" id_proyecto,"
					+" id_tipo_documento_preinversion,"
					+" tipo_documento_preinversion,"					
					+" documento_preinversion, "				
					+" usuario," 
					+" fecha_registro) values "
					+ "(?,?,?,?,?,sysdate())";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proyecto());
			pstm.setInt(2, o.getId_tipo_documento_preinversion());			
			pstm.setString(3, o.getTipo_documento_preinversion());
			pstm.setString(4, o.getDocumento_preinversion());				
			pstm.setString(5, o.getUsuario());
			
			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void Eliminar(Documento_preinversion o) throws Exception {
		
		Connection cn = null;
		
		try {			
			cn = DataAccess.getConnection();

			String sql = " update documento_preinversion set activo = 0, fecha_ultima_modificacion = sysdate() where id_documento_preinversion = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);
			
			pstm.setInt(1, o.getId_documento_preinversion());

			pstm.executeUpdate();

			pstm.close();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void Modificar(Documento_preinversion o) throws Exception {
		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update documento_preinversion set "	
					+" id_tipo_documento_preinversion = ?,"
					+" tipo_documento_preinversion = ?,"					
					+" documento_preinversion = ?,"
					+" usuario = ?,"				
					+" fecha_ultima_modificacion = sysdate() "
					+" where id_documento_preinversion = ? and activo = 1";
					
			PreparedStatement pstm = cn.prepareStatement(sql);
		
			pstm.setInt(1, o.getId_tipo_documento_preinversion());			
			pstm.setString(2, o.getTipo_documento_preinversion());
			pstm.setString(3, o.getDocumento_preinversion());	
			pstm.setString(4, o.getUsuario());	
			
			pstm.setInt(5, o.getId_documento_preinversion());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public List<Documento_preinversion> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Documento_preinversion> Filtrar(Documento_preinversion o) throws Exception {
		
		Connection cn = null;
       
		List<Documento_preinversion> lista = new ArrayList<Documento_preinversion>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select "	
            		+" id_documento_preinversion,"
					+" id_proyecto,"
					+" id_tipo_documento_preinversion,"
					+" tipo_documento_preinversion,"
					+" documento_preinversion,"	
					+" usuario "
					+ "from documento_preinversion "					
					+" where id_proyecto = ? and activo = 1 order by id_documento_preinversion asc";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, o.getId_proyecto());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	Documento_preinversion d = new Documento_preinversion();
				// asignar valores al objeto r
				d.setId_documento_preinversion(rs.getInt("id_documento_preinversion"));
				d.setId_proyecto(rs.getInt("id_proyecto"));
				d.setId_tipo_documento_preinversion(rs.getInt("id_tipo_documento_preinversion"));				
				d.setTipo_documento_preinversion(rs.getString("tipo_documento_preinversion"));	
				d.setDocumento_preinversion(rs.getString("documento_preinversion"));				
				d.setUsuario(rs.getString("usuario"));
													
				lista.add(d);
            }
            // cerrar cursor
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
	}

	@Override
	public Documento_preinversion Buscar(Documento_preinversion o) throws Exception {
		
		Connection cn = null;		
        Documento_preinversion d = new Documento_preinversion();    
        
        try {
            cn = DataAccess.getConnection();
            
            String sql = " select "	
            		+" id_documento_preinversion,"
					+" id_proyecto,"
					+" id_tipo_documento_preinversion,"
					+" tipo_documento_preinversion,"
					+" documento_preinversion,"
					+" usuario from documento_preinversion "					
					+" where id_documento_preinversion = ? and activo = 1";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, o.getId_documento_preinversion());
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	d.setId_documento_preinversion(rs.getInt("id_documento_preinversion"));
				d.setId_proyecto(rs.getInt("id_proyecto"));
				d.setId_tipo_documento_preinversion(rs.getInt("id_tipo_documento_preinversion"));
				d.setTipo_documento_preinversion(rs.getString("tipo_documento_preinversion"));	
				d.setDocumento_preinversion(rs.getString("documento_preinversion"));				
				d.setUsuario(rs.getString("usuario"));    				                

            }
            
            rs.close();
            pstm.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return d;
	}		

}
