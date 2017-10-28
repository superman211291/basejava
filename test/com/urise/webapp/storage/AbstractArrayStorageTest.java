package com.urise.webapp.storage;

import com.urise.webapp.exeption.ExistStorageException;
import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.exeption.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by superman on 11.10.17.
 */
public abstract class AbstractArrayStorageTest {

    protected Storage storage;
    public static Resume resume=new Resume("uuid4");

    public AbstractArrayStorageTest(Storage storage) {
        this.storage=storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0,storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r = new Resume(UUID_1);
        Assert.assertFalse(storage.get(UUID_1)==r);
        storage.update(r);
        Assert.assertTrue(storage.get(UUID_1)==r);
    }

    @Test
    public void getAll() throws Exception {
       Resume[] r = storage.getAll();
       Resume[] r1 = {new Resume(UUID_1),new Resume(UUID_2), new Resume(UUID_3)};
       Assert.assertArrayEquals(r,r1);
    }

    @Test
    public void save() throws Exception {
        storage.save(resume);
        Assert.assertThat(resume,is(storage.get("uuid4")));
        existstorageexeption();
        storageowerflow();
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_2);
        Assert.assertEquals(2,storage.size());
    }

    @Test
    public void get() throws Exception {
        Resume r =storage.get(UUID_1);
        Resume r1 = new Resume(UUID_1);
        Assert.assertEquals(r,r1);

    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void existstorageexeption() {
        try {
            storage.save(resume);
            Assert.fail();
        }
        catch (ExistStorageException ex) {
            Assert.assertThat(ex.getMessage(), is("Resume uuid4 already exist"));
        }
    }

    private void storageowerflow(){
        try {
            String s = null;
            for (int i = 5; i <10001; i++) {
                s = "uuid"+i;
                storage.save(new Resume(s));
            }
            storage.save(new Resume("uuid"));
            Assert.fail();
        }
        catch (StorageException ex){
            Assert.assertThat(ex.getMessage(),is("Storage overflow"));
        }
    }

}