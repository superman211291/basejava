package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

/**
 * Created by superman on 29.10.17.
 */
public class ListStorage extends AbstractStorage {

    private ArrayList <Resume> resumeArrayList = new ArrayList<>();

    @Override
    public void clear() {
        resumeArrayList.clear();
        super.clear();
    }

    @Override
    public void update(Resume r) {
        super.update(r);
        resumeArrayList.add(getIndex(r.getUuid()),r);
    }

    @Override
    public Resume get(String uuid) {
        super.get(uuid);
        return resumeArrayList.get(getIndex(uuid));
    }

    @Override
    public Resume[] getAll() {
        super.resumes=null;
        super.resumes=resumeArrayList.toArray(new Resume[resumeArrayList.size()]);
        return super.getAll();
    }



    @Override
    protected int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i <resumeArrayList.size() ; i++) {
            if (resumeArrayList.get(i).getUuid().equals(uuid))
                index=i;
        }
        return index;
    }

    @Override
    protected void insertElement(Resume r, int index) {
        resumeArrayList.add(r);
    }

    @Override
    protected void fillDeletedElement(int index) {
        resumeArrayList.remove(index);

    }
}
