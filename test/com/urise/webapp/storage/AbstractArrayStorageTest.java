package com.urise.webapp.storage;

import com.urise.webapp.exeption.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by superman on 11.10.17.
 */
public class AbstractArrayStorageTest {
    private Storage storage=new ArrayStorage();


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
        Resume resume = new Resume("uuid4");
        storage.save(resume);
        Assert.assertTrue(storage.get("uuid4").equals(resume));

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

}