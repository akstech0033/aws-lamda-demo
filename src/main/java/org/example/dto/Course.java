package org.example.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
@DynamoDBTable(tableName = "courses")
public class Course {

    @DynamoDBHashKey(attributeName = "id")
    private int id;
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private double price;
}
