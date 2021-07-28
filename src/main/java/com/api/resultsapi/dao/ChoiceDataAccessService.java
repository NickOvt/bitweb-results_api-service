package com.api.resultsapi.dao;

import com.api.resultsapi.models.Choice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceDataAccessService implements ChoiceDao {

    private final JdbcTemplate jdbcTemplate;

    public ChoiceDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Choice> selectAllChoices() {
        final String query = "SELECT id, choice_value FROM choice";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            String choice_value = resultSet.getString("choice_value");
            return new Choice(choice_value);
        });
    }
}
