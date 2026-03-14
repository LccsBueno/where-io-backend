package analu.whereio.application.service.local;

import analu.whereio.adapters.out.external.geocoding.record.LatitudeLongitudeRecord;
import analu.whereio.application.mapper.LocalServiceMapper;
import analu.whereio.application.model.Local;
import analu.whereio.application.ports.in.local.CadastrarLocalUsecase;
import analu.whereio.application.ports.out.LatitudeLongitudeInterfacePort;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class CadastrarLocalUsecaseImpl implements CadastrarLocalUsecase {

    private final LocalRepositoryPort localRepositoryPort;
    private final LatitudeLongitudeInterfacePort latitudeLongitudePort;
    private final LocalServiceMapper localServiceMapper;
//    private final GeocodingPort geocodingPort;

    @Override
    public Local execute(Local local) {

        if(!isNull(localRepositoryPort.buscarPorNomeLocal(local.getNome()))){
            throw new BusinessException("Restaurante já cadastrado", HttpStatus.UNPROCESSABLE_CONTENT);
        }

        local.setJaVisitou(false);

        try{
            LatitudeLongitudeRecord record = latitudeLongitudePort.ConverterEnderecoParaCoordenadas(local.getEndereco().toString());
            local.setLatitude(record.latitude());
            local.setLongitude(record.longitude());

        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new BusinessException("Restaurante não foi encontrado", HttpStatus.NOT_FOUND);
        }

        return localRepositoryPort.cadastrarLocal(local);
    }
}
