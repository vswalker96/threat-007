from reportlab.lib import colors
from reportlab.lib.pagesizes import letter
from reportlab.platypus import SimpleDocTemplate, Table, TableStyle, Paragraph, Spacer
from reportlab.lib.styles import getSampleStyleSheet


def generate_pdf_with_reportlab(
    report_text,
    components_data,
    scenarios_data,
    agents_data,
    stride_data,
    output_filename,
):
    # Create a PDF document
    pdf = SimpleDocTemplate(output_filename, pagesize=letter)

    # Container for the 'flowable' objects
    elements = []

    # Set up the styles for the document
    styles = getSampleStyleSheet()

    # Add the report text
    sections = report_text.split("\n\n")
    for section in sections:
        title, body = section.split(":", 1)
        elements.append(Paragraph(f"<b>{title.strip()}</b>", styles["Heading2"]))
        elements.append(Paragraph(body.strip(), styles["BodyText"]))
        elements.append(Spacer(1, 12))

    # Add Components Table
    elements.append(Paragraph("<b>Components and Connections</b>", styles["Heading2"]))
    elements.append(
        Paragraph("Table showing components and their connections.", styles["BodyText"])
    )

    components_table_data = [["Component", "Connection"]] + components_data
    components_table = Table(components_table_data)
    components_table.setStyle(
        TableStyle(
            [
                ("BACKGROUND", (0, 0), (-1, 0), colors.grey),
                ("TEXTCOLOR", (0, 0), (-1, 0), colors.whitesmoke),
                ("ALIGN", (0, 0), (-1, -1), "CENTER"),
                ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
                ("BOTTOMPADDING", (0, 0), (-1, 0), 12),
                ("BACKGROUND", (0, 1), (-1, -1), colors.beige),
                ("GRID", (0, 0), (-1, -1), 1, colors.black),
            ]
        )
    )
    elements.append(components_table)
    elements.append(Spacer(1, 12))

    # Add Threat Scenarios Table
    elements.append(Paragraph("<b>Threat Scenarios</b>", styles["Heading2"]))
    elements.append(
        Paragraph("Table listing all possible threat scenarios.", styles["BodyText"])
    )

    scenarios_table_data = [
        ["Scenario", "Component", "STRIDE Category", "Likelihood", "Impact"]
    ] + scenarios_data
    scenarios_table = Table(scenarios_table_data)
    scenarios_table.setStyle(
        TableStyle(
            [
                ("BACKGROUND", (0, 0), (-1, 0), colors.grey),
                ("TEXTCOLOR", (0, 0), (-1, 0), colors.whitesmoke),
                ("ALIGN", (0, 0), (-1, -1), "CENTER"),
                ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
                ("BOTTOMPADDING", (0, 0), (-1, 0), 12),
                ("BACKGROUND", (0, 1), (-1, -1), colors.beige),
                ("GRID", (0, 0), (-1, -1), 1, colors.black),
            ]
        )
    )
    elements.append(scenarios_table)
    elements.append(Spacer(1, 12))

    # Add Threat Agents and Actors Table
    elements.append(Paragraph("<b>Threat Agents and Actors</b>", styles["Heading2"]))
    elements.append(
        Paragraph("Table listing threat agents and actors.", styles["BodyText"])
    )

    agents_table_data = [["Threat Agent", "Actor Role"]] + agents_data
    agents_table = Table(agents_table_data)
    agents_table.setStyle(
        TableStyle(
            [
                ("BACKGROUND", (0, 0), (-1, 0), colors.grey),
                ("TEXTCOLOR", (0, 0), (-1, 0), colors.whitesmoke),
                ("ALIGN", (0, 0), (-1, -1), "CENTER"),
                ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
                ("BOTTOMPADDING", (0, 0), (-1, 0), 12),
                ("BACKGROUND", (0, 1), (-1, -1), colors.beige),
                ("GRID", (0, 0), (-1, -1), 1, colors.black),
            ]
        )
    )
    elements.append(agents_table)
    elements.append(Spacer(1, 12))

    # Add STRIDE-LM Mapping Table
    elements.append(Paragraph("<b>STRIDE-LM Mapping</b>", styles["Heading2"]))
    elements.append(
        Paragraph("Table mapping threats to STRIDE-LM categories.", styles["BodyText"])
    )

    stride_table_data = [["Threat Scenario", "STRIDE-LM Category"]] + stride_data
    stride_table = Table(stride_table_data)
    stride_table.setStyle(
        TableStyle(
            [
                ("BACKGROUND", (0, 0), (-1, 0), colors.grey),
                ("TEXTCOLOR", (0, 0), (-1, 0), colors.whitesmoke),
                ("ALIGN", (0, 0), (-1, -1), "CENTER"),
                ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
                ("BOTTOMPADDING", (0, 0), (-1, 0), 12),
                ("BACKGROUND", (0, 1), (-1, -1), colors.beige),
                ("GRID", (0, 0), (-1, -1), 1, colors.black),
            ]
        )
    )
    elements.append(stride_table)
    elements.append(Spacer(1, 12))

    # Build the PDF
    pdf.build(elements)


# Example data to populate the report and tables
report_text = """\
Threat Summary: This report covers the identified security threats in the architecture.
Threat Objectives: To minimize risk, protect data integrity, confidentiality, and availability.
"""

components_data = [["ComponentA", "ComponentB"], ["ComponentB", "ComponentA"]]
scenarios_data = [
    [
        "SQL Injection",
        "ComponentB",
        "Tampering",
        "High",
        "Confidentiality: High, Integrity: High, Availability: Medium",
    ]
]
agents_data = [["Attacker", "External"]]
stride_data = [["SQL Injection", "Tampering"]]

# Call the function to generate PDF
generate_pdf_with_reportlab(
    report_text,
    components_data,
    scenarios_data,
    agents_data,
    stride_data,
    "threat_model_report.pdf",
)
