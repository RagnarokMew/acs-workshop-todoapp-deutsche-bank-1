//package com.bianca.todo.dto;
//
//import com.bianca.todo.model.Guest;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class GuestMapper {
//
//    public static GuestDTO toDTO(Guest guest) {
//        List<TaskDTO> taskDTOs = guest.getTasks().stream()
//                .map(task -> new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(),task.getDueDate()))
//                .collect(Collectors.toList());
//
//        return new GuestDTO(guest.getId(), guest.getName(), taskDTOs);
//    }
//}
//
