package ftcApp.service;

import ftcApp.model.Parcel;
import ftcApp.model.enums.ParcelStatus;
import ftcApp.repository.ItemRepository;
import ftcApp.repository.ParcelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

@Service
@Transactional
public class ParcelServiceImpl extends GenericServiceImpl<Parcel, Integer> implements ParcelService {
    @Inject
    private ItemRepository itemRepository;

    @Inject
    ParcelServiceImpl(ParcelRepository repository) {
        super(repository, Parcel.class);
    }

    @Override
    public void updateParcelStatus(Integer id, ParcelStatus status) {
        ((ParcelRepository)repository).updateParcelStatus(id, status);
    }

    @Override
    public void updateParcelColdStore(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        parcel.setStatus(ParcelStatus.REGISTERED_BY_CSM);
        parcel.setArrived(new Date());
        repository.update(parcel);
    }

    @Override
    public Iterable<Parcel> findParcelsNotRegisteredInColdStore() {
        return ((ParcelRepository) repository).findParcelsNotRegisteredInColdStore();
    }
}
