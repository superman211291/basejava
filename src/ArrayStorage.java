import java.util.ArrayList;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        storage=new Resume[10000];
    }

    void save(Resume r) {
        storage[count]=r;
        count++;
    }

    Resume get(String uuid) {
        for (int i=0;i<storage.length;i++){
            if (uuid.equals(storage[i].uuid)){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <count; i++) {
            if (storage[i].uuid.equals(uuid)){
                storage[i]=null;

            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll()
    {
        Resume[] resumes = new Resume[count];
        for (int i = 0; i <resumes.length ; i++) {
            resumes[i]=storage[i];

        }
       return resumes;
    }

    int size(){
        return count;
    }
}
