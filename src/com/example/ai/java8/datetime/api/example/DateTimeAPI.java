package com.example.ai.java8.datetime.api.example;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DateTimeAPI {

	public static void main(String[] args) {
		// 1) Create a list of all the dates in the current month:
		YearMonth yearMonth = YearMonth.now();
	//	System.out.println(yearMonth );
		List<LocalDate> datesInMonth = IntStream.rangeClosed(15, yearMonth.lengthOfMonth())
		    .mapToObj(day -> LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), day))
		    .collect(Collectors.toList());
	//	System.out.println(datesInMonth);
		
	  //	2) Check if a given list of dates contains only weekends:
		
		List<LocalDate> dates = Arrays.asList(LocalDate.of(2024, 12, 7), LocalDate.of(2024, 12, 8));
		boolean allWeekends = dates.stream()
		    .allMatch(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
		//System.out.println(allWeekends);
		
		// 3) find five leap year 
		List<Integer> leapYears = Stream.iterate(Year.now().getValue(), year -> year + 1)
			    .filter(year -> Year.of(year).isLeap())
			    .limit(5)
			    .collect(Collectors.toList());
		//	System.out.println(leapYears);
 // 4) Calculate the total hours worked in a week:
			List<LocalDateTime[]> workPeriods = Arrays.asList(
				    new LocalDateTime[]{LocalDateTime.of(2024, 12, 2, 9, 0), LocalDateTime.of(2024, 12, 2, 17, 0)},
				    new LocalDateTime[]{LocalDateTime.of(2024, 12, 3, 10, 0), LocalDateTime.of(2024, 12, 3, 18, 0)}
				);
				long totalHours = workPeriods.stream()
				    .mapToLong(period -> Duration.between(period[0], period[1]).toHours())
				    .sum();
				System.out.println("Total hours worked: " + totalHours);
  // 5) Group birthdays by day of the week:
				List<LocalDate> birthdays =  Arrays.asList(LocalDate.of(1990, 1, 15), LocalDate.of(1995, 5, 20), LocalDate.of(1988, 12, 10));
				Map<DayOfWeek, List<LocalDate>> groupedByDay = birthdays.stream()
				    .collect(Collectors.groupingBy(LocalDate::getDayOfWeek));
				System.out.println(groupedByDay);
  //6) Find the first Monday of each month for the next year:
				List<LocalDate> firstMondays = IntStream.rangeClosed(1, 12)
					    .mapToObj(month -> YearMonth.of(Year.now().getValue() + 1, month).atDay(1))
					    .map(date -> date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)))
					    .collect(Collectors.toList());
					System.out.println(firstMondays);
//7) Calculate the difference in days between the earliest and latest dates in a list:
					List<LocalDate> dates1 = Arrays.asList(LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 10));
					long daysDifference = ChronoUnit.DAYS.between(
					    dates1.stream().min(Comparator.naturalOrder()).orElseThrow(),
					    dates1.stream().max(Comparator.naturalOrder()).orElseThrow()
					);
					System.out.println("Difference in days: " + daysDifference);
// 8)  Find overlapping date ranges:
					List<LocalDate[]> dateRanges = Arrays.asList(
						    new LocalDate[]{LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 10)},
						    new LocalDate[]{LocalDate.of(2024, 12, 5), LocalDate.of(2024, 12, 15)},
						    new LocalDate[]{LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 25)}
						);
						boolean hasOverlap = dateRanges.stream().anyMatch(range1 ->
						    dateRanges.stream().anyMatch(range2 ->
						        range1 != range2 &&
						        (range1[1].isAfter(range2[0]) || range1[1].isEqual(range2[0])) &&
						        (range1[0].isBefore(range2[1]) || range1[0].isEqual(range2[1]))
						    )
						);
						System.out.println("Has overlapping ranges: " + hasOverlap);

					

	}
}
