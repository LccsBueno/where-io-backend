package analu.restaurantes_api.application.ports.out;

import analu.restaurantes_api.adapters.out.external.geocoding.record.LatitudeLongitudeRecord;
import java.io.IOException;

public interface LatitudeLongitudeInterfacePort {

    LatitudeLongitudeRecord ConverterEnderecoParaCoordenadas(String endereco) throws IOException, InterruptedException;
}
