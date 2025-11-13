import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodegaTest {

    private Bodega bodega;
    private final String NOMBRE_PRODUCTO = "Leche Prueba";

    @BeforeEach
    void setUp() {
        bodega = new Bodega();
        Producto producto = new Producto(NOMBRE_PRODUCTO, 10, 5);
        bodega.agregarProducto(producto);
    }

    // Requerimiento 1: Prueba agregarStock (Suma)
    @Test
    void testAgregarStockSumaCorrectamente() {
        bodega.agregarStock(NOMBRE_PRODUCTO, 5);
        assertEquals(15, bodega.buscarProducto(NOMBRE_PRODUCTO).getStock(), 
                     "El stock debe ser 15 (10+5)");
    }

    // Requerimiento 2: Prueba restarStock (Éxito)
    @Test
    void testRestarStockDescuentaCorrectamente() {
        boolean resultado = bodega.restarStock(NOMBRE_PRODUCTO, 3);
        assertTrue(resultado, "La operación debe ser exitosa");
        assertEquals(7, bodega.buscarProducto(NOMBRE_PRODUCTO).getStock(), 
                     "El stock debe ser 7 (10-3)");
    }

    // Requerimiento 3: Prueba restarStock (Sin Negativos)
    @Test
    void testRestarStockNoPermiteNegativos() {
        boolean resultado = bodega.restarStock(NOMBRE_PRODUCTO, 11);
        assertFalse(resultado, "Restar stock no debe ser exitoso si resulta en stock negativo");
        assertEquals(10, bodega.buscarProducto(NOMBRE_PRODUCTO).getStock(), 
                     "El stock debe permanecer en 10 si se intenta vender de más");
    }
}