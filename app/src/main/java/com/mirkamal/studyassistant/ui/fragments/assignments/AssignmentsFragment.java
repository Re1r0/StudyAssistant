package com.mirkamal.studyassistant.ui.fragments.assignments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamal.studyassistant.R;
import com.mirkamal.studyassistant.database.Assignment;
import com.mirkamal.studyassistant.database.FakeDataBase;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsFragment extends Fragment {

    private RecyclerView recyclerView;
    private FakeDataBase dataBase;
    private List<Assignment> assignments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_assignments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view_assignments);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        AssignmentsRecyclerViewAdapter adapter = new AssignmentsRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        dataBase = FakeDataBase.getInstance();
        assignments = new ArrayList<>();

        dataBase.getAssignments().forEach((key, value) -> {
            assignments.add(value);
        });

        adapter.submitList(assignments);
    }
}
