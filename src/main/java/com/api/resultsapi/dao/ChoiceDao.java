package com.api.resultsapi.dao;

import com.api.resultsapi.models.Choice;

import java.util.List;

public interface ChoiceDao {
    List<Choice> selectAllChoices();
}
