//package objetosNegocio;
//
//import Interface.IIngredienteBO;
//import adaptadores.IngredienteAdapter;
//import daos.IngredienteDAO;
//import dtos.IngredienteDTO;
//import entidadesMongo.Ingrediente;
//import excepcion.NegocioException;
//import excepciones.PersistenciaException;
//import interfaces.IIngredienteDAO;
//import java.util.List;
//
///**
// * BO de ingredientes.
// * Trabaja con DTOs hacia presentación y entidades hacia persistencia.
// * 
// * @author DishUp
// */
//public class IngredienteBO {
//
//    private final IIngredienteDAO ingredienteDAO;
//    private final IngredienteAdapter ingredienteAdapter;
//
//    public IngredienteBO() {
//        this.ingredienteDAO = new IngredienteDAO();
//        this.ingredienteAdapter = new IngredienteAdapter();
//    }
//
//    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
//        this.ingredienteDAO = ingredienteDAO;
//        this.ingredienteAdapter = new IngredienteAdapter();
//    }
//
//    public List<IngredienteDTO> obtenerIngredientes()
//            throws NegocioException {
//
//        try {
//            List<Ingrediente> ingredientes =
//                    ingredienteDAO.obtenerIngredientes();
//
//            return ingredienteAdapter.listEntityToDTO(ingredientes);
//
//        } catch (PersistenciaException ex) {
//            throw new NegocioException("No fue posible obtener los ingredientes.", ex);
//        }
//    }
//}